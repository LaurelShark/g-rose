package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;

import static com.gildedrose.QualityConstants.*;

public class BackstagePassStrategy implements ItemUpdateStrategy {

    @Override
    public void apply(Item item) {
        item.sellIn -= STANDARD_RATE;

        if (item.sellIn < EXPIRED_SELL_IN) {
            item.quality = MIN_QUALITY;
        } else if (item.sellIn < BACKSTAGE_TRIPLE_THRESHOLD) {
            item.quality = Math.min(MAX_QUALITY, item.quality + BACKSTAGE_TRIPLE_INCREMENT);
        } else if (item.sellIn < BACKSTAGE_DOUBLE_THRESHOLD) {
            item.quality = Math.min(MAX_QUALITY, item.quality + BACKSTAGE_DOUBLE_INCREMENT);
        } else {
            item.quality = Math.min(MAX_QUALITY, item.quality + STANDARD_RATE);
        }
    }
}
