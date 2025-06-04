package com.gildedtros;

import com.gildedtros.domain.Item;
import com.gildedtros.item_types.TypedItem;
import com.gildedtros.mapper.ItemTypeMapper;
import com.gildedtros.visitor.ItemVisitor;
import com.gildedtros.visitor.UpdateQualityVisitor;

import java.util.List;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public GildedTros(List<Item> items) {
        this(items.toArray(new Item[0]));
    }

    public void updateQuality() {
        ItemVisitor visitor = new UpdateQualityVisitor();
        for (Item item : items) {
            TypedItem typedItem = ItemTypeMapper.map(item);
            typedItem.accept(visitor);
        }
    }
}