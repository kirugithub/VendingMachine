package vending;
/** To represent all the coins that can be used in the vending machine
 * @author kirusureshkumar
 * Pe-Penny, Ni-Nickel, Di-Dime and Qu-Quarter
 */
public enum Coin{

    Pe(1), Ni(5), Di(10), Qu(25);

    private int denomination;

    private Coin(int denomination){
        this.denomination = denomination;
    }
    public int getDenomination(){
        return denomination;
    }

}