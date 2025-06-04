package com.gildedtros;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.TypedItem;
import com.gildedtros.mapper.ItemTypeMapper;
import com.gildedtros.updater.ItemUpdater;
import com.gildedtros.updater.ItemUpdaterFactory;

import java.util.List;

class GildedTros {
    private final Item[] items;
    private final ItemUpdaterFactory itemupdaterFactory;

    public GildedTros(List<Item> items) {
        this(items.toArray(new Item[0]));
    }

    public GildedTros(Item[] items) {
        this.items = items;
        this.itemupdaterFactory = new ItemUpdaterFactory();
    }

    public void updateQuality() {
        for (Item item : items) {
            TypedItem typedItem = new TypedItem(item, ItemTypeMapper.map(item));
            ItemUpdater updater = itemupdaterFactory.getUpdater(typedItem.type());
            updater.update(typedItem);
        }
    }

}