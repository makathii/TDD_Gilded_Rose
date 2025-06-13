package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testConjuredItemsBeforeSellDate(){
        Item[] items = new Item[] {new Item("COnjured Mana Cake", 5, 10)};
        GildedRose app= new GildedRose(items);
        app.updateQuality();
        assertEquals(4,app.items[0].sellIn);
        assertEquals(8,app.items[0].quality);
    }

}
