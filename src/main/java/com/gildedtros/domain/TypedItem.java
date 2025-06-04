package com.gildedtros.domain;

import com.gildedtros.Item;
import lombok.Data;

@Data
public class TypedItem {
    private final Item item;
    private final ItemType type;

    public TypedItem(Item item, ItemType type) {
        this.item = item;
        this.type = type;
    }
}
