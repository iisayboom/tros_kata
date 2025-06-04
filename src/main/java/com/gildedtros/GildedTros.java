package com.gildedtros;

import com.gildedtros.domain.TypedItem;
import com.gildedtros.mapper.ItemTypeMapper;

import java.util.List;

class GildedTros {
    private final Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public GildedTros(List<Item> items) {
        this.items = items.toArray(new Item[0]);
    }

    public void updateQuality() {
        for (Item item : items) {
            TypedItem typedItem = new TypedItem(item, ItemTypeMapper.map(item));
            updateItem(typedItem);
        }
    }

    private void updateItem(TypedItem typedItem) {
        Item item = typedItem.getItem();

        switch (typedItem.getType()) {
            case LEGENDARY -> {
                // no changes needed for legendary items
            }
            case GOOD_WINE -> {
                item.sellIn--;
                if (item.quality < 50) {
                    item.quality++;
                }
            }
            case BACKSTAGE_REF, BACKSTAGE_HAXX -> {
                item.sellIn--;

                if (item.sellIn < 0) {
                    item.quality = 0;
                } else if (item.sellIn < 5) {
                    item.quality = Math.min(50, item.quality + 3);
                } else if (item.sellIn < 10) {
                    item.quality = Math.min(50, item.quality + 2);
                } else {
                    item.quality = Math.min(50, item.quality + 1);
                }
            }
            case NORMAL -> {
                item.sellIn--;
                int degrade = (item.sellIn < 0) ? 2 : 1;
                item.quality = Math.max(0, item.quality - degrade);
            }
        }
    }

}