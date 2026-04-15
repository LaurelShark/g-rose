package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassStrategyTest {

    @ParameterizedTest(name = "sellIn={0}, quality={1} -> sellIn={2}, quality={3}")
    @CsvSource({
        // >10 days: +1
        "15, 20, 14, 21",
        "12, 20, 11, 21",
        "11, 20, 10, 21",
        // <=10 days: +2
        "10, 20, 9, 22",
        "7, 20, 6, 22",
        "6, 20, 5, 22",
        // <=5 days: +3
        "5, 20, 4, 23",
        "3, 20, 2, 23",
        "1, 20, 0, 23",
        // after concert
        "0, 20, -1, 0",
        "-1, 20, -2, 0",
        // quality cap
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
        // from zero
        "15, 0, 14, 1",
        "8, 0, 7, 2",
        "3, 0, 2, 3",
        "0, 0, -1, 0",
    })
    void qualityChanges(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        new BackstagePassStrategy().apply(item);
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
}
