package com.vendingmachine;

import com.vendingmachine.models.Coin;
import com.vendingmachine.models.Item;
import com.vendingmachine.models.ItemShelf;
import com.vendingmachine.models.ItemType;
import com.vendingmachine.vendingStates.State;

public class Main {
    public static void main(String[] args) {
        try {
            VendingMachine vendingMachine = new VendingMachine();
            
            System.out.println("|--- Filling up the inventory ---|");
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);
            
            System.out.println("\n|--- Clicking on Insert Coin Button ---|");
            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);
            
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.DIME);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            
            System.out.println("\n|--- Clicking on Product Selection Button ---|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);
            
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102); // 102 is PEPSI, costs 30
            
            displayInventory(vendingMachine);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        try {
            ItemShelf[] slots = vendingMachine.getInventory().getInventory();
            for (int i = 0; i < slots.length; i++) {
                Item newItem = new Item();
                if (i >= 0 && i < 3) {
                    newItem.setType(ItemType.COKE);
                    newItem.setPrice(25);
                } else if (i >= 3 && i < 5) {
                    newItem.setType(ItemType.PEPSI);
                    newItem.setPrice(30);
                } else if (i >= 5 && i < 7) {
                    newItem.setType(ItemType.JUICE);
                    newItem.setPrice(40);
                } else if (i >= 7 && i < 10) {
                    newItem.setType(ItemType.SODA);
                    newItem.setPrice(20);
                }
                slots[i].setItem(newItem);
                slots[i].setSoldOut(false);
                slots[i].setQuantity(5); // adding quantity 5 for each slot
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            System.out.println("Code: " + slots[i].getCode() + 
                " Item: " + (slots[i].isSoldOut() ? "Sold Out" : slots[i].getItem().getType().name()) + 
                " Price: " + (slots[i].isSoldOut() ? "-" : slots[i].getItem().getPrice()) + 
                " Qty: " + slots[i].getQuantity());
        }
    }
}
