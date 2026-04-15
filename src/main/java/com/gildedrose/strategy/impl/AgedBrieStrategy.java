package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;

import static com.gildedrose.QualityConstants.*;

public class AgedBrieStrategy implements ItemUpdateStrategy {

    @Override
    public void apply(Item item) {
        item.sellIn -= STANDARD_RATE;
        int appreciation = item.sellIn < EXPIRED_SELL_IN
            ? STANDARD_RATE * EXPIRED_MULTIPLIER
            : STANDARD_RATE;
        item.quality = Math.min(MAX_QUALITY, item.quality + appreciation);
    }
}
