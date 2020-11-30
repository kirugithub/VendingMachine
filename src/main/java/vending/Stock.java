package vending;

import java.util.HashMap;
import java.util.Map;

/** Java class to represent stock inside the vending machine.
 * In this implementation we have Items for purchase and coins to tendered as stocks
 * @author kirusureshkumar
 * This is a generic class that can work on any type of data.
 * When an instance is created, it will be specified if it is of Coin datatype or Item data type
 * For Coin data type it will be integer and for Item datatype it will be String
 */
public class Stock<T> {

    private Map<T, Integer> stock = new HashMap<T, Integer>();

    // Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key
    public int getQuantity(T product){
        Integer value = stock.get(product);//.get(parameter) is a method within MAP class.
        return value == null? 0 : value ;
    }
    //Method to add items to the stock
    public void add(T product){
        int count = stock.get(product);  //.put(parameter, parameter) is a method within Map class
        stock.put(product,count+1);
    }
    //Method to put more than 1 item
    public void putItem(T product, int quantity) {
        stock.put(product, quantity);
    }
    //Method to deduct items from the stock
    public void deduct(T product) {
        if (hasItem(product))
        {
            int count = stock.get(product);
            stock.put(product, count - 1);
        }
    }
    //Method to check if there are items in the stock to be tendered
    public boolean hasItem(T product)
    {
        return getQuantity(product)>0;
    }
    //Method to clear all items from the stock
    public void clear(){
        stock.clear();
    }

}

