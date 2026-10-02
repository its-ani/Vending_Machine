package com.vendingmachine.vendingStates;

import com.vendingmachine.VendingMachine;
import com.vendingmachine.models.Coin;
import com.vendingmachine.models.Item;
import java.util.List;

public interface State {
    void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;
    void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    void chooseProduct(VendingMachine machine, int itemCode) throws Exception;
    int getChange(int returnChangeMoney) throws Exception;
    Item dispenseProduct(VendingMachine machine, int itemCode) throws Exception;
    List<Coin> refundFullMoney(VendingMachine machine) throws Exception;
    void updateInventory(VendingMachine machine, Item item, int itemCode, int quantity) throws Exception;
}
