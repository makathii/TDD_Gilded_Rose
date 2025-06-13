package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testConjuredItemsBeforeSellDate(){
        Item[] items = new Item[] {new Item("Conjured Mana Cake", 5, 10)};
        GildedRose app= new GildedRose(items);
        app.updateQuality();
        assertEquals(4,app.items[0].sellIn);
        assertEquals(8,app.items[0].quality);
    }

    @Test
    public void testConjuredItemsAfterSellDate(){
        Item[] items= new Item[]{new Item("Conjured Mana Cake",0,10)};
        GildedRose app= new GildedRose(items);
        app.updateQuality();
        assertEquals(-1,app.items[0].sellIn);
        assertEquals(6,app.items[0].quality);
    }

    @Test
    public void testNormalItemBeforeSellDate(){
        Item[] items= new Item[]{new Item("Normal Item",10,20)};
        GildedRose app= new GildedRose(items);
        app.updateQuality();
        assertEquals(9,app.items[0].sellIn);
        assertEquals(19,app.items[0].quality);
    }

    @Test
    public void testNormalItemAfterSellDate(){
        Item[] items= new Item[]{new Item("Normal Item",0,20)};
        GildedRose app= new GildedRose(items);
        app.updateQuality();
        assertEquals(-1,app.items[0].sellIn);
        assertEquals(18,app.items[0].quality);
    }

    @Test
    public void testAgedBrieIncreasesQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

    @Test
    public void testAgedBrieIncreasesQualityAfterSellDate() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(49, items[0].quality);  // increases twice as fast
    }


}
