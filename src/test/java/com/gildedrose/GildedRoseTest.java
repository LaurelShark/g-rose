package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @ParameterizedTest(name = "Normal: sellIn={0}, quality={1} -> sellIn={2}, quality={3}")
    @CsvSource({
        "10, 20, 9, 19",
        "1, 20, 0, 19",
        "0, 20, -1, 18",
        "-1, 20, -2, 18",
        "10, 0, 9, 0",
        "0, 1, -1, 0",
        "-1, 1, -2, 0",
        "0, 0, -1, 0",
        "5, 50, 4, 49",
        "0, 3, -1, 1",
    })
    void normalItem(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] { new Item("Normal Item", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @ParameterizedTest(name = "Aged Brie: sellIn={0}, quality={1} -> sellIn={2}, quality={3}")
    @CsvSource({
        "10, 20, 9, 21",
        "1, 20, 0, 21",
        "0, 20, -1, 22",
        "-1, 20, -2, 22",
        "10, 50, 9, 50",
        "10, 49, 9, 50",
        "0, 49, -1, 50",
        "0, 48, -1, 50",
        "-1, 50, -2, 50",
        "5, 0, 4, 1",
        "0, 0, -1, 2",
    })
    void agedBrie(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @ParameterizedTest(name = "Sulfuras: sellIn={0}, quality={1} -> unchanged")
    @CsvSource({
        "0, 80, 0, 80",
        "-1, 80, -1, 80",
        "10, 80, 10, 80",
        "5, 40, 5, 40",
    })
    void sulfuras(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @ParameterizedTest(name = "Backstage: sellIn={0}, quality={1} -> sellIn={2}, quality={3}")
    @CsvSource({
        "15, 20, 14, 21",
        "12, 20, 11, 21",
        "11, 20, 10, 21",
        "10, 20, 9, 22",
        "7, 20, 6, 22",
        "6, 20, 5, 22",
        "5, 20, 4, 23",
        "3, 20, 2, 23",
        "1, 20, 0, 23",
        "0, 20, -1, 0",
        "-1, 20, -2, 0",
        "15, 50, 14, 50",
        "10, 50, 9, 50",
        "5, 50, 4, 50",
        "15, 49, 14, 50",
        "10, 49, 9, 50",
        "5, 49, 4, 50",
        "5, 48, 4, 50",
        "10, 48, 9, 50",
        "5, 47, 4, 50",
        "0, 50, -1, 0",
        "15, 0, 14, 1",
        "8, 0, 7, 2",
        "3, 0, 2, 3",
        "0, 0, -1, 0",
    })
    void backstagePasses(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @ParameterizedTest(name = "Conjured: sellIn={0}, quality={1} -> sellIn={2}, quality={3}")
    @CsvSource({
        "10, 20, 9, 18",
        "0, 20, -1, 16",
        "10, 0, 9, 0",
        "0, 1, -1, 0",
        "5, 1, 4, 0",
    })
    void conjuredItem(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void itemNameDoesNotChange() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void emptyItemsArray() {
        GildedRose app = new GildedRose(new Item[0]);
        app.updateQuality();
    }

    @Test
    void multipleItemsUpdatedIndependently() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
        assertEquals(1, items[1].sellIn);
        assertEquals(1, items[1].quality);
        assertEquals(0, items[2].sellIn);
        assertEquals(80, items[2].quality);
    }
}
