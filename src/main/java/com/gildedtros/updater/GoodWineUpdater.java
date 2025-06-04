package com.gildedtros.updater;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.TypedItem;

public class GoodWineUpdater implements ItemUpdater {

    private static final int MAX_QUALITY = 50;
    private static final int QUALITY_INCREMENT = 1;

    @Override
    public void update(TypedItem typedItem) {
        Item item = typedItem.getItem();
        item.sellIn--;

        if (canIncreaseQuality(item)) {
            item.quality += QUALITY_INCREMENT;
        }
    }

    private boolean canIncreaseQuality(Item item) {
        return item.quality < MAX_QUALITY;
    }
}
