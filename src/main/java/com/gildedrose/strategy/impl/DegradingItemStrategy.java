package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;

import static com.gildedrose.QualityConstants.*;

public class DegradingItemStrategy implements ItemUpdateStrategy {

    private final int rateMultiplier;

    public DegradingItemStrategy(int rateMultiplier) {
        this.rateMultiplier = rateMultiplier;
    }

    @Override
    public void apply(Item item) {
        item.sellIn -= STANDARD_RATE;
        int baseRate = STANDARD_RATE * rateMultiplier;
        int degradation = item.sellIn < EXPIRED_SELL_IN
            ? baseRate * EXPIRED_MULTIPLIER
            : baseRate;
        item.quality = Math.max(MIN_QUALITY, item.quality - degradation);
    }
}
