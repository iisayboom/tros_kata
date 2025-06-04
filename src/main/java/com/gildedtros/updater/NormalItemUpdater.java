package com.gildedtros.updater;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.TypedItem;

public class NormalItemUpdater implements ItemUpdater {

    private static final int NORMAL_DEGRADATION = 1;
    private static final int EXPIRED_DEGRADATION = 2;
    private static final int MIN_QUALITY = 0;

    @Override
    public void update(TypedItem typedItem) {
        Item item = typedItem.item();
        item.sellIn--;

        int degradeQualityBy = isExpired(item) ? EXPIRED_DEGRADATION : NORMAL_DEGRADATION;
        item.quality = Math.max(MIN_QUALITY, item.quality - degradeQualityBy);
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
}
