# Gilded Rose Refactoring Kata

My solution to the [Gilded Rose Refactoring Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata) in Java.

## Approach

Replaced the monolithic `updateQuality()` method with **Strategy Pattern** and map-based dispatch.

Each item type has its own strategy class implementing `ItemUpdateStrategy`. A `StrategyResolver` maps item names to strategies via `HashMap`, with `StandardItemStrategy` as the default fallback.

`DegradingItemStrategy` serves as a parameterized base for items that lose quality, avoiding duplication between standard and conjured items.

## Project Structure

```
com.gildedrose/
  strategy/          - ItemUpdateStrategy interface
  strategy/impl/     - Per-item-type implementations
  factory/           - StrategyResolver (map-based dispatch)
```

## Build & Test

```bash
./gradlew test
```
