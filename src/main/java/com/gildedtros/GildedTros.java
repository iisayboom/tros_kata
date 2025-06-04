package com.gildedtros;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.ItemType;
import com.gildedtros.domain.TypedItem;
import com.gildedtros.mapper.ItemTypeMapper;
import com.gildedtros.updater.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

class GildedTros {
    private final Item[] items;
    private final Map<ItemType, ItemUpdater> updaters;

    public GildedTros(List<Item> items) {
        this(items.toArray(new Item[0]));
    }

    public GildedTros(Item[] items) {
        this.items = items;
        this.updaters = new EnumMap<>(ItemType.class);

        updaters.put(ItemType.NORMAL, new NormalItemUpdater());
        updaters.put(ItemType.GOOD_WINE, new GoodWineUpdater());
        updaters.put(ItemType.BACKSTAGE_REF, new BackstagePassUpdater());
        updaters.put(ItemType.BACKSTAGE_HAXX, new BackstagePassUpdater());
        updaters.put(ItemType.LEGENDARY, new LegendaryItemUpdater());
        updaters.put(ItemType.SMELLY, new SmellyItemUpdater());
    }

    public void updateQuality() {
        for (Item item : items) {
            TypedItem typedItem = new TypedItem(item, ItemTypeMapper.map(item));
            ItemUpdater updater = updaters.get(typedItem.getType());
            updater.update(typedItem);
        }
    }

}