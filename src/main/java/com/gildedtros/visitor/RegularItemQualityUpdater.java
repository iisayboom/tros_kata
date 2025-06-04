package com.gildedtros.visitor;

import com.gildedtros.item_types.RegularItem;

public class RegularItemQualityUpdater implements QualityUpdater<RegularItem> {
    @Override
    public void update(RegularItem item) {
        item.decreaseSellInByOne();
        int decrease = item.getSellIn() < 0 ? 2 : 1;
        item.decreaseQuality(decrease);
    }
}