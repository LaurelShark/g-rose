package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredItemStrategyTest {

    @ParameterizedTest(name = "sellIn={0}, quality={1} -> sellIn={2}, quality={3}")
    @CsvSource({
        "10, 20, 9, 18",
        "1, 20, 0, 18",
        "0, 20, -1, 16",
        "-1, 20, -2, 16",
        "10, 0, 9, 0",
        "10, 1, 9, 0",
        "5, 2, 4, 0",
        "0, 0, -1, 0",
        "0, 1, -1, 0",
        "0, 3, -1, 0",
        "0, 4, -1, 0",
        "0, 5, -1, 1",
        "5, 50, 4, 48",
    })
    void doubleDegradation(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item item = new Item("Conjured Mana Cake", sellIn, quality);
        new ConjuredItemStrategy().apply(item);
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
}
