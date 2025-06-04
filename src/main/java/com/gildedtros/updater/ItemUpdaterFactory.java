package com.gildedtros.updater;

import com.gildedtros.domain.ItemType;

import java.util.EnumMap;
import java.util.Map;

public class ItemUpdaterFactory {
    private final Map<ItemType, ItemUpdater> updaters = new EnumMap<>(ItemType.class);

    public ItemUpdaterFactory() {
        updaters.put(ItemType.NORMAL, new NormalItemUpdater());
        updaters.put(ItemType.GOOD_WINE, new GoodWineUpdater());
        updaters.put(ItemType.BACKSTAGE_REF, new BackstagePassUpdater());
        updaters.put(ItemType.BACKSTAGE_HAXX, new BackstagePassUpdater());
        updaters.put(ItemType.LEGENDARY, new LegendaryItemUpdater());
        updaters.put(ItemType.SMELLY, new SmellyItemUpdater());
    }

    public ItemUpdater getUpdater(ItemType itemType) {
        return updaters.get(itemType);
    }
}
