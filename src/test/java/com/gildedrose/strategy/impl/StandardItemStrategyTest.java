package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardItemStrategyTest {

    @ParameterizedTest(name = "sellIn={0}, quality={1} -> sellIn={2}, quality={3}")
    @CsvSource({
        // Standard degradation
        "10, 20, 9, 19",
        "1, 20, 0, 19",
        // Double degradation after sell by date
        "0, 20, -1, 18",
        "-1, 20, -2, 18",
        // Quality never negative
        "10, 0, 9, 0",
        "0, 1, -1, 0",
        "-1, 1, -2, 0",
        "0, 0, -1, 0",
        // High quality degrades normally
        "5, 50, 4, 49",
        // Partial double degradation
        "0, 3, -1, 1",
    })
    void degradation(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item item = new Item("Normal Item", sellIn, quality);
        new StandardItemStrategy().apply(item);
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
}
