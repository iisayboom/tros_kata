package com.gildedtros.visitor;

import com.gildedtros.item_types.LegendaryItem;

public class LegendaryItemQualityUpdater implements QualityUpdater<LegendaryItem> {
    @Override
    public void update(LegendaryItem item) {
        // do nothing - legendary items do not change quality
    }
}