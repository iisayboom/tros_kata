package com.gildedtros.updater;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.TypedItem;

public class SmellyItemUpdater implements ItemUpdater {

    private static final int SMELLY_MULTIPLIER = 2;
    private static final int MIN_QUALITY = 0;

    @Override
    public void update(TypedItem typedItem) {
        Item item = typedItem.getItem();
        item.sellIn--;

        int baseDegradation = isExpired(item) ? 2 : 1;
        int totalDegradation = baseDegradation * SMELLY_MULTIPLIER;

        item.quality = Math.max(MIN_QUALITY, item.quality - totalDegradation);
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
}
