package src.main.java.com.gildedrose;

import java.util.HashMap;

public class GildedRose {

    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        initCategoryMap();
    }

    // Categories
    HashMap<String, String> category = new HashMap<String, String>();

    public void initCategoryMap() {
        category.put("Aged Brie", "AGED");
        category.put("Sulfuras, Hand of Ragnaros", "LEGENDARY");
        category.put("Backstage passes to a TAFKAL80ETC concert", "PASSES");
        category.put("Conjured Mana Cake", "CONJURED");
    }

    public void updateQuality() {
        for(Item item:items) {
            if(item.name.equals("Aged Brie")){
                updateAGED(item);
            }
            if(item.name.equals("Sulfuras, Hand of Ragnaros")){
                updateLEGENDARY(item);
            }
            if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                updatePASSES(item);
            }
            if(item.name.equals("Conjured Mana Cake")){
                updateCONJURED(item);
            }
            if(item.name.equals("Elixir of the Mongoose")){
                updateOTHER(item);
            }
            updateSellIn(item);
        }
    }

    public void updateSellIn(Item item){
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.setSellIn(item.getSellIn()-1);
        }
    }

    public int increaseQuality(Item item){
        if(item.getQuality() < 50){
            item.setQuality(item.getQuality()+1);
        }
        return item.getQuality();
    }

    /* Category Methods*/

    public void updateAGED(Item item){
        // quality goes up when sellIn decreases
        item.setQuality(increaseQuality(item));
    }
    public void updateLEGENDARY(Item item){
        // Quality = 80
        item.setQuality(80);
    }
    public void updatePASSES(Item item){
        // quality increases by 2 when there are 10 days or less
        // quality increases by 3 when there are 5 days or less
        // quality = 0 after concert

        item.setQuality(increaseQuality(item));

        if(item.getSellIn() <= 10){
            item.setQuality(increaseQuality(item));
        }
        if(item.getSellIn() <= 5){
            item.setQuality(increaseQuality(item));
        }
        if(item.sellIn <= 0){
            item.setQuality(0);
        }
    }
    public void updateCONJURED(Item item){
        // degrades in quality twice as fast
        item.setQuality(item.getQuality()-2);
    }
    public void updateOTHER(Item item){
        // once sell by date has passed quality degrades twice as fast
        if(item.getSellIn() < 0){
            item.setQuality(item.getQuality()-2);
        }
        else{
            item.setQuality(item.getQuality()-1);
        }
    }
}