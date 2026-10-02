package com.vendingmachine.vendingStates.impl;

import com.vendingmachine.VendingMachine;
import com.vendingmachine.models.Coin;
import com.vendingmachine.models.Item;
import com.vendingmachine.vendingStates.State;
import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.out.println("Currently Vending machine is in HasMoneyState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted the coin: " + coin.name() + " with value: " + coin.value);
        machine.getCoinList().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine machine, int itemCode) throws Exception {
        throw new Exception("You need to click on start product selection button first");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can not get change in hasMoney state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int itemCode) throws Exception {
        throw new Exception("You can not dispense Product in hasMoney state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int itemCode, int quantity) throws Exception {
        throw new Exception("You can not update inventory in hasMoney state");
    }
}
