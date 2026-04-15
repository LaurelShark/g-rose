package com.gildedrose.factory;

import com.gildedrose.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;
import com.gildedrose.strategy.impl.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StrategyResolverTest {

    @Test
    void agedBrieResolvesToAgedBrieStrategy() {
        ItemUpdateStrategy strategy = StrategyResolver.resolve(new Item("Aged Brie", 0, 0));
        assertTrue(strategy instanceof AgedBrieStrategy);
    }

    @Test
    void sulfurasResolvesToLegendaryItemStrategy() {
        ItemUpdateStrategy strategy = StrategyResolver.resolve(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        assertTrue(strategy instanceof LegendaryItemStrategy);
    }

    @Test
    void backstagePassResolvesToBackstagePassStrategy() {
        ItemUpdateStrategy strategy = StrategyResolver.resolve(
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0));
        assertTrue(strategy instanceof BackstagePassStrategy);
    }

    @Test
    void conjuredResolvesToConjuredItemStrategy() {
        ItemUpdateStrategy strategy = StrategyResolver.resolve(new Item("Conjured Mana Cake", 0, 0));
        assertTrue(strategy instanceof ConjuredItemStrategy);
    }

    @Test
    void unknownItemResolvesToStandardStrategy() {
        ItemUpdateStrategy strategy = StrategyResolver.resolve(new Item("Random Thing", 0, 0));
        assertTrue(strategy instanceof StandardItemStrategy);
    }

    @Test
    void nullItemResolvesToStandardStrategy() {
        ItemUpdateStrategy strategy = StrategyResolver.resolve(null);
        assertTrue(strategy instanceof StandardItemStrategy);
    }
}
