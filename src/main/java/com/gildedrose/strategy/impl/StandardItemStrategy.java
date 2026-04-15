package com.gildedrose.strategy.impl;

import static com.gildedrose.QualityConstants.STANDARD_RATE;

public class StandardItemStrategy extends DegradingItemStrategy {

    public StandardItemStrategy() {
        super(STANDARD_RATE);
    }
}
