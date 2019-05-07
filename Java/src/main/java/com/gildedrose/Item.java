package src.main.java.com.gildedrose;

public class Item {

    public String name;

    public String category;

    public int sellIn;

    public int quality;

    public Item(String name, String category, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.category + ", " + this.sellIn + ", " + this.quality;
    }

    /**Getters & Setters**/
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public int getSellIn(){
        return sellIn;
    }
    public void setSellIn(int sellIn){
        this.sellIn = sellIn;
    }
    public int getQuality(){
        return quality;
    }
    public void setQuality(int quality){
        this.quality = quality;
    }
}
