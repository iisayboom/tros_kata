package com.gildedtros;

import com.gildedtros.domain.Item;
import com.gildedtros.item_types.TypedItem;
import com.gildedtros.mapper.ItemTypeMapper;
import com.gildedtros.visitor.ItemVisitor;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemVisitor visitor = new UpdateQualityVisitor();
        for (Item item : items) {
            TypedItem typedItem = ItemTypeMapper.map(item);
            typedItem.accept(visitor);
        }
    }
}