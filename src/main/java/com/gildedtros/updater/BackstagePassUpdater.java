package com.gildedtros.updater;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.TypedItem;

public class BackstagePassUpdater implements ItemUpdater {

    private static final int MAX_QUALITY = 50;
    private static final int TEN_DAYS_REMAINING = 10;
    private static final int FIVE_DAYS_REMAINING = 5;

    @Override
    public void update(TypedItem typedItem) {
        Item item = typedItem.getItem();
        item.sellIn--;

        if (eventIsOver(item)) {
            item.quality = 0;
            return;
        }

        int incrementQualityBy = calculateQualityIncrease(item.sellIn);
        item.quality = Math.min(MAX_QUALITY, item.quality + incrementQualityBy);
    }

    private boolean eventIsOver(Item item) {
        return item.sellIn < 0;
    }

    private int calculateQualityIncrease(int sellIn) {
        if (sellIn < FIVE_DAYS_REMAINING) {
            return 3;
        } else if (sellIn < TEN_DAYS_REMAINING) {
            return 2;
        } else {
            return 1;
        }
    }
}
