package com.vendingmachine.vendingStates.impl;

import com.vendingmachine.VendingMachine;
import com.vendingmachine.models.Coin;
import com.vendingmachine.models.Item;
import com.vendingmachine.vendingStates.State;
import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Currently Vending machine is in IdleState");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("First you need to click on insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You can not insert Coin in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int itemCode) throws Exception {
        throw new Exception("You can not choose Product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can not get change in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int itemCode) throws Exception {
        throw new Exception("You can not dispense Product in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("You can not get refunded in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int itemCode, int quantity) throws Exception {
        machine.getInventory().addItem(item, itemCode, quantity);
    }
}
