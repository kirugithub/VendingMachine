package vending;

/** @author kirusureshkumar
 * */
public enum Item {
    COKE("Coke", 23), PEPSI("Pepsi", 20), SODA("Soda", 45);
    private String name;
    private int price;

    private Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
