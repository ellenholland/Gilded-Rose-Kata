package src.test.java.com.gildedrose;

import org.junit.Test;
import src.main.java.com.gildedrose.GildedRose;
import src.main.java.com.gildedrose.Item;

import static org.junit.Assert.*;

public class GildedRoseTest {

    /*QUALITY*/

    @Test
    public void normalQualityTest() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, app.items[0].getSellIn());
        assertEquals(9, app.items[0].getQuality());
    }

    @Test
    public void qualityIsNeverMoreThanFiftey() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, app.items[0].getSellIn());
        assertEquals(50, app.items[0].getQuality());
    }

    @Test
    public void qualityDegradesTwiceAsFastAfterSellInTest() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-2, app.items[0].getSellIn());
        assertEquals(8, app.items[0].getQuality());
    }

    @Test (expected = AssertionError.class)
    public void qualityIsNeverNegativeTest() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -5, 0) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-6, app.items[0].getSellIn());
        assertEquals(-1, app.items[0].getQuality());
    }

    @Test
    public void qualityIsNeverMoreThanFifteyTest() {
        Item[] items = new Item[] { new Item("Aged Brie", -20, 50) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-21, app.items[0].getSellIn());
        assertEquals(50, app.items[0].getQuality());
    }

    /*AGED*/

    @Test
    public void agedBrieQualityIncreaseTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(1, app.items[0].getSellIn());
        assertEquals(1, app.items[0].getQuality());
    }

    /*LEGENDARY*/

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

    /*PASSES*/

    @Test
    public void backstagePassesQualityIncreaseCloserToSellInTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(14, app.items[0].getSellIn());
        assertEquals(21, app.items[0].getQuality());
    }

    @Test
    public void backstagePassesQualityIncreaseByTwoWhenSellInTenDaysOrLessTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 7, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, app.items[0].getSellIn());
        assertEquals(22, app.items[0].getQuality());

        assertEquals(6, app.items[1].getSellIn());
        assertEquals(22, app.items[1].getQuality());
    }

    @Test
    public void backstagePassesQualityIncreaseByThreeWhenFiveDaysOrLessTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 2, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, app.items[0].getSellIn());
        assertEquals(23, app.items[0].getQuality());

        assertEquals(1, app.items[1].getSellIn());
        assertEquals(23, app.items[1].getQuality());
    }

    @Test
    public void backstagePassesQualityZeroAfterSellInTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // day of concert, still quality
        assertEquals(0, app.items[0].getSellIn());
        assertEquals(23, app.items[0].getQuality());

        // day after concert, no quality
        assertEquals(-1, app.items[1].getSellIn());
        assertEquals(0, app.items[1].getQuality());
    }

    /*CONJURED*/

    @Test
    public void conjuredItemsDegradeQualityTwiceAsFastTest() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(2, app.items[0].getSellIn());
        assertEquals(4, app.items[0].getQuality());
    }
}
