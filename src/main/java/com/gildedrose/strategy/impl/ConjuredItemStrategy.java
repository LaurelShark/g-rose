package com.gildedrose.strategy.impl;

import static com.gildedrose.QualityConstants.CONJURED_MULTIPLIER;

public class ConjuredItemStrategy extends DegradingItemStrategy {

    public ConjuredItemStrategy() {
        super(CONJURED_MULTIPLIER);
    }
}
