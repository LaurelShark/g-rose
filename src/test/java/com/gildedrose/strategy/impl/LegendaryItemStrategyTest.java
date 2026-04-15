package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LegendaryItemStrategyTest {

    @ParameterizedTest(name = "sellIn={0}, quality={1} -> unchanged")
    @CsvSource({
        "0, 80, 0, 80",
        "-1, 80, -1, 80",
        "10, 80, 10, 80",
        "5, 40, 5, 40",
    })
    void neverChanges(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item item = new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
        new LegendaryItemStrategy().apply(item);
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
}
