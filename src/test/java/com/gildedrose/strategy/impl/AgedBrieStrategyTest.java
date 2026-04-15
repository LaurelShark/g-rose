package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieStrategyTest {

    @ParameterizedTest(name = "sellIn={0}, quality={1} -> sellIn={2}, quality={3}")
    @CsvSource({
        // Standard appreciation
        "10, 20, 9, 21",
        "1, 20, 0, 21",
        // Double appreciation after sell by date
        "0, 20, -1, 22",
        "-1, 20, -2, 22",
        // Quality cap at 50
        "10, 50, 9, 50",
        "10, 49, 9, 50",
        // Quality cap with double appreciation
        "0, 49, -1, 50",
        "0, 48, -1, 50",
        "-1, 50, -2, 50",
        // From quality zero
        "5, 0, 4, 1",
        "0, 0, -1, 2",
    })
    void appreciation(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item item = new Item("Aged Brie", sellIn, quality);
        new AgedBrieStrategy().apply(item);
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
}
