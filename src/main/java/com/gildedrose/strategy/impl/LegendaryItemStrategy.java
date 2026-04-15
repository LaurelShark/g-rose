package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;

public class LegendaryItemStrategy implements ItemUpdateStrategy {

    @Override
    public void apply(Item item) {
        // Legendary items never change in quality or sellIn
    }
}
