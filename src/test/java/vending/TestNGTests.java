package vending;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGTests {
    private static VendingMachineInAction vem;

    @BeforeTest
    public static void setup(){
        vem = new VendingMachineInAction();
    }
    @AfterTest
    public static void tearDown(){
        vem = null;
    }
    @Test
    public static void testBuyItemWithCorrectChange(){
        long price = vem.pickItemAndGetPrice(Item.PEPSI);
        Assert.assertEquals(20, Item.PEPSI.getPrice());
        //20 paid for Pepsi
        vem.insertCoin(Coin.Di);
        vem.insertCoin(Coin.Di);
        VendingContainer vc = vem.collectItemAndChange();
        Item it = (Item)vc.getFirst();
        List<Coin> ch = (List<Coin>) vc.getSecond();
        Assert.assertEquals(Item.PEPSI, it);
        Assert.assertTrue(ch.isEmpty());
    }

    @Test
    public static void testBuyItemWithExtraChange(){
        long price = vem.pickItemAndGetPrice(Item.SODA);
        Assert.assertEquals(45, Item.SODA.getPrice());
        //2 Quarters paid
        vem.insertCoin(Coin.Qu);
        vem.insertCoin(Coin.Qu);
        VendingContainer vc = vem.collectItemAndChange();
        Item it = (Item)vc.getFirst();
        Assert.assertEquals(Item.SODA, it);
        List<Coin> change = (List<Coin>)vc.getSecond();
        Assert.assertTrue(!( change.isEmpty()));
        // Assert.assertEquals(5, change);
    }
}

