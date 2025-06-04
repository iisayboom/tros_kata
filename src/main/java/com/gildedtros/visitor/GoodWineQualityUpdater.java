package com.gildedtros.visitor;

import com.gildedtros.item_types.GoodWine;

public class GoodWineQualityUpdater implements QualityUpdater<GoodWine> {
    @Override
    public void update(GoodWine item) {
        item.decreaseSellInByOne();
        item.increaseQuality(item.getSellIn() < 0 ? 2 : 1);
    }
}