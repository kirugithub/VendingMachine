package vending;

/** Parameterised utility class to contain 2 different objects
 * @param <E1>- Item
 * @param <E2>- Coin
 * @author kirusureshkumar
 */
public class VendingContainer<E1, E2> {
    private E1 first;
    private E2 second;

    public VendingContainer(E1 first, E2 second){
        this.first = first;
        this.second = second;
    }

    public E1 getFirst(){
        return first;
    }

    public E2 getSecond(){
        return second;
    }
}

