package vending;
import java.util.List;
/** Declare public APIs for Vending Machine
 * Create a Framework to high-level functionalities as methods in the Interface
 * pickItemAndGetPrice method takes item of type Item(enum- group of constants) and returns a value of type long
 * insertCoin method takes coin as a parameter which is type Coin (Enum- group of constants)
 * refund method refunds coins after purchase and returns a List of type Coin which is an Enum
 * collectItemAndChange method returns a value of type VendingContainer which holds Item and List of coins as change on purchase by the user
 * reset method will clear all values from various variables
 * @author kirusureshkumar
 */
public interface VendingMachineFramework {
    public long pickItemAndGetPrice(Item item);
    public void insertCoin(Coin coin);
    public VendingContainer<Item, List<Coin>> collectItemAndChange();
    public List<Coin> refundCash();
    public void reset();

}