package src.test.java.com.gildedrose;

import org.junit.Test;
import src.main.java.com.gildedrose.GildedRose;
import src.main.java.com.gildedrose.Item;

import static org.junit.Assert.*;
import src.main.java.com.gildedrose.Item;

public class GildedRoseTest {

    @Test
    public void qualityDegradesTwiceAsFastAfterSellInTest() {

    }

    @Test
    public void qualityIsNeverNegativeTest() {

    }

    @Test
    public void qualityIsNeverMoreThanFifteyTest() {

    }

    @Test
    public void agedBrieQualityIncreaseTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(1, app.items[0].getSellIn());
        assertEquals(1, app.items[0].getQuality());
    }

    @Test
    public void sulfurasLegendaryFixedQualityNoSellInTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 80),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].getName());
        assertEquals(2, app.items[0].getSellIn());
        assertEquals(80, app.items[0].getQuality());

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].getName());
        assertEquals(0, app.items[1].getSellIn());
        assertEquals(80, app.items[1].getQuality());
    }

    @Test
    public void backstagePassesTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

    }

    @Test
    public void backstagePassesQualityIncreaseCloserToSellInTest() {

    }

    @Test
    public void backstagePassesQualityIncreaseWhenSellInTenDaysOrLessTest() {

    }

    @Test
    public void backstagePassesQualityIncreaseByThreeWhenFiveDaysOrLessTest() {

    }

    @Test
    public void backstagePassesQualityZeroAfterSellInTest() {

    }

    @Test
    public void conjuredItemsDegradeQualityTwiceAsFastTest() {

    }
}
