package src.main.java.com.gildedrose;

public class GildedRose {

    enum quality{
        MAX_QUALITY(50);
        private int quality;
        quality(int quality){
            this.quality = quality;
        }
    }


    enum itemCategory{
        AGED("Aged Brie"),
        LEGENDARY("Sulfuras, Hand of Ragnaros"),
        PASSES("Backstage passes to a TAFKAL80ETC concert"),
        CONJURED("Conjured Mana Cake");
        private String category;
        public String getCategory() {
            return this.category;
        }
        itemCategory(String category) {
            this.category = category;
        }
    }

    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for(Item item:items) {
            if(item.name.equals("Aged Brie")){
                updateAGED(item);
                updateSellIn(item);
            }
            if(item.name.equals("Sulfuras, Hand of Ragnaros")){
                updateLEGENDARY(item);
                updateSellIn(item);
            }
            if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                updatePASSES(item);
                updateSellIn(item);
            }
            if(item.name.equals("Conjured Mana Cake")){
                updateCONJURED(item);
                updateSellIn(item);
            }
            updateSellIn(item);
        }
        // if quality is negative, make 0.
        // if quality is more than 50, unless legendary
    }
    public void updateSellIn(Item item){
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.setSellIn(item.getSellIn()-1);
        }
    }

    public void updateAGED(Item item){
        // quality goes up when sellIn decreases
        item.setQuality(increaseQuality(item));
    }
    public void updateLEGENDARY(Item item){
        // Quality = 80,
        item.setQuality(80);
    }
    public void updatePASSES(Item item){
        // quality increases by 2 when there are 10 days or less
        // quality increases by 3 when there are 5 days or less
        // quality = 0 after concert

        if(item.getSellIn()>10){
            item.setQuality(increaseQuality(item));
        }
        else if(item.getSellIn() <= 10){
            item.setQuality(increaseQuality(item));
        }
        else if(item.getSellIn() <= 5){
            item.setQuality(increaseQuality(item));
        }
        if(item.sellIn <= 0){
            item.setQuality(0);
        }
    }
    public void updateCONJURED(Item item){
        // degrades in quality twice as fast
    }
    
    public int increaseQuality(Item item){
        if(item.getQuality() < 50){
            item.setQuality(item.getQuality()+1);
        }
        return item.getQuality();
    }
    // other:
    // once sell by date has passed quality degrades twice as fast
}