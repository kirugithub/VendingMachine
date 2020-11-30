package vending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**  Java Implementation of Vending Machine
 * @author kirusureshkumar
 */
public class VendingMachineInAction implements VendingMachineFramework {

    //Stock is a generic class. cashStock returns Stock<Coin>. Coin represents cash in machine
    private Stock<Coin> cashStock = new Stock<Coin>();

    //itemStock returns Stock<Item> as a return type. Item represents items in the machine
    private Stock<Item> itemStock = new Stock<Item>();

    private long totalSales;
    private Item currentItem; //Item is an enum (group of constants)
    private long currentBalance;

    //Default constructor. This will run every time VendingMachineInAction is called
    public VendingMachineInAction()
    {
        initialise();
    }

    //initialise machine with 5 coins of each denomination
    //initialise machine with 5 cans of each item
    private void initialise(){
        for(Coin c: Coin.values()){
            cashStock.putItem(c,5);
        }
        for(Item i : Item.values()){
            itemStock.putItem(i,5);
        }
    }

    @Override
    public long pickItemAndGetPrice(Item item) {
        if(itemStock.hasItem(item))
        {
            currentItem= item;
            return currentItem.getPrice();
        }
        throw new SoldOutException("Sold out, Please buy another item");
    }

    @Override
    public void insertCoin(Coin coin) {//check this
        currentBalance = currentBalance + coin.getDenomination();
        cashStock.add(coin);
    }

    @Override
    public List<Coin> refundCash() {
        List<Coin> refund = getChange(currentBalance);
        updateCashStock(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    @Override
    public VendingContainer<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
        List<Coin> change = collectChange();
        return new VendingContainer<Item, List<Coin>>(item,change);
    }
    private Item collectItem() throws NotSufficientChangeException,NotFullPaidException{
        if(isFullPaid()){
            if(hasSufficientChange()){
                itemStock.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("No Sufficient Change in the Inventory");
        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining : ", remainingBalance);
    }
    private List<Coin> collectChange() {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashStock(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }


    private boolean isFullPaid() {
        if(currentBalance >= currentItem.getPrice()){
            return true;
        }
        return false;
    }

    private List<Coin> getChange(long amount) throws NotSufficientChangeException {
        List<Coin> changes = Collections.EMPTY_LIST;///explain

        if(amount > 0){
            changes = new ArrayList<Coin>();
            long balance = amount;
            while(balance > 0){
                if(balance >= Coin.Qu.getDenomination()
                        && cashStock.hasItem(Coin.Qu)){
                    changes.add(Coin.Qu);
                    balance = balance - Coin.Qu.getDenomination();
                    continue;

                }else if(balance >= Coin.Di.getDenomination()
                        && cashStock.hasItem(Coin.Di)) {
                    changes.add(Coin.Di);
                    balance = balance - Coin.Di.getDenomination();
                    continue;

                }else if(balance >= Coin.Ni.getDenomination()
                        && cashStock.hasItem(Coin.Ni)) {
                    changes.add(Coin.Ni);
                    balance = balance - Coin.Ni.getDenomination();
                    continue;

                }else if(balance >= Coin.Pe.getDenomination()
                        && cashStock.hasItem(Coin.Pe)) {
                    changes.add(Coin.Pe);
                    balance = balance - Coin.Pe.getDenomination();
                    continue;

                }else{
                    throw new NotSufficientChangeException("NotSufficientChange, Please try another product");
                }
            }
        }

        return changes;
    }

    @Override
    public void reset() {
        cashStock.clear();
        itemStock.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }
    public void printStats(){
        System.out.println("Total Sales : " + totalSales);
        System.out.println("Current Item Inventory : " + itemStock);
        System.out.println("Current Cash Inventory : " + cashStock);
    }
    private boolean hasSufficientChange(){
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }
    private boolean hasSufficientChangeForAmount(long amount){
        boolean hasChange = true;
        try{ getChange(amount);
        }
        catch(NotSufficientChangeException nsce){
            return hasChange = false;
        }
        return hasChange;
    }
    private void updateCashStock(List<Coin> change) {
        for(Coin c : change) {
            cashStock.deduct(c);
        }
    }
    public long getTotalSales(){
        return totalSales;
    }

}

