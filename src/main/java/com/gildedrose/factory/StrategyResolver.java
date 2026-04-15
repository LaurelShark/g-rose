package com.gildedrose.factory;

import com.gildedrose.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;
import com.gildedrose.strategy.impl.*;

import java.util.HashMap;
import java.util.Map;

public class StrategyResolver {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private static final ItemUpdateStrategy DEFAULT_STRATEGY = new StandardItemStrategy();

    private static final Map<String, ItemUpdateStrategy> STRATEGIES;

    static {
        STRATEGIES = new HashMap<String, ItemUpdateStrategy>();
        STRATEGIES.put(AGED_BRIE, new AgedBrieStrategy());
        STRATEGIES.put(SULFURAS, new LegendaryItemStrategy());
        STRATEGIES.put(BACKSTAGE_PASSES, new BackstagePassStrategy());
    }

    public static ItemUpdateStrategy resolve(Item item) {
        if (item == null || item.name == null) {
            return DEFAULT_STRATEGY;
        }
        return STRATEGIES.getOrDefault(item.name, DEFAULT_STRATEGY);
    }
}
