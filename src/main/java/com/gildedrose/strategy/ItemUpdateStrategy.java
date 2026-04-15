package com.gildedrose.strategy;

import com.gildedrose.Item;

public interface ItemUpdateStrategy {
    void apply(Item item);
}
