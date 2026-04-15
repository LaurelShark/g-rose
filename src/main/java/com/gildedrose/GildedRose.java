package com.gildedrose;

import com.gildedrose.factory.StrategyResolver;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            StrategyResolver.resolve(item).apply(item);
        }
    }
}
