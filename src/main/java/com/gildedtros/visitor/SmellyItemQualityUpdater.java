package com.gildedtros.visitor;

import com.gildedtros.item_types.SmellyItem;

public class SmellyItemQualityUpdater implements QualityUpdater<SmellyItem> {
    @Override
    public void update(SmellyItem item) {
        item.decreaseSellInByOne();
        if (item.getSellIn() < 0) {
            item.decreaseQuality(4);
        } else {
            item.decreaseQuality(2);
        }
    }
}