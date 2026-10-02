package com.vendingmachine.vendingStates.impl;

import com.vendingmachine.VendingMachine;
import com.vendingmachine.models.Coin;
import com.vendingmachine.models.Item;
import com.vendingmachine.vendingStates.State;
import java.util.List;

public class DispenseState implements State {

    public DispenseState(VendingMachine machine, int itemCode) throws Exception {
        System.out.println("Currently Vending machine is in DispenseState");
        dispenseProduct(machine, itemCode);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("You can not click on insert coin button in Dispense state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("You can not click on start product selection button in Dispense state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You can not insert Coin in Dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int itemCode) throws Exception {
        throw new Exception("You can not choose Product in Dispense state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can not get change in Dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int itemCode) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(itemCode);
        machine.getInventory().decrementItemQuantity(itemCode);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("You can not get refunded in Dispense state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int itemCode, int quantity) throws Exception {
        throw new Exception("You can not update inventory in Dispense state");
    }
}
