package com.gildedtros.visitor;

import com.gildedtros.item_types.BackstagePasses;

public class BackstagePassesQualityUpdater implements QualityUpdater<BackstagePasses> {
    @Override
    public void update(BackstagePasses item) {
        item.decreaseSellInByOne();
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        } else if (item.getSellIn() < 5) {
            item.increaseQuality(3);
        } else if (item.getSellIn() < 10) {
            item.increaseQuality(2);
        } else {
            item.increaseQuality(1);
        }
    }
}