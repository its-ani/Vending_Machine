package com.vendingmachine.vendingStates.impl;

import com.vendingmachine.VendingMachine;
import com.vendingmachine.models.Coin;
import com.vendingmachine.models.Item;
import com.vendingmachine.vendingStates.State;
import java.util.List;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Currently Vending machine is in SelectionState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("You can not click on insert coin button in Selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You can not insert Coin in Selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int itemCode) throws Exception {
        // 1. Get item from inventory
        Item item = machine.getInventory().getItem(itemCode);

        // 2. Calculate total amount paid by user
        int paidByUser = 0;
        for (Coin coin : machine.getCoinList()) {
            paidByUser += coin.value;
        }

        // 3. Compare with item price
        if (paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney(machine);
            throw new Exception("Insufficient amount");
        } else {
            if (paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, itemCode));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int itemCode) throws Exception {
        throw new Exception("You can not dispense Product in Selection state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int itemCode, int quantity) throws Exception {
        throw new Exception("You can not update inventory in Selection state");
    }
}
