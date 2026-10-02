package com.vendingmachine.models;

public class Inventory {
    private ItemShelf[] inventory;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            space.setQuantity(0);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int code, int quantity) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == code) {
                if (itemShelf.isSoldOut() || itemShelf.getQuantity() == 0) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                    itemShelf.setQuantity(quantity);
                } else if (itemShelf.getItem().getType().equals(item.getType())) {
                    itemShelf.setQuantity(itemShelf.getQuantity() + quantity);
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("Already a different item is present, you cannot add this item here");
                }
            }
        }
    }

    public Item getItem(int code) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == code) {
                if (itemShelf.isSoldOut() || itemShelf.getQuantity() == 0) {
                    throw new Exception("Item already sold out");
                } else {
                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Invalid Item Code");
    }

    public void decrementItemQuantity(int code) {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == code) {
                if (itemShelf.getQuantity() > 0) {
                    itemShelf.setQuantity(itemShelf.getQuantity() - 1);
                }
                if (itemShelf.getQuantity() == 0) {
                    itemShelf.setSoldOut(true);
                }
            }
        }
    }
}
