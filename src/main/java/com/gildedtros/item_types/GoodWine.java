package com.gildedtros.item_types;

import com.gildedtros.domain.Item;
import com.gildedtros.visitor.ItemVisitor;

public class GoodWine extends TypedItem {

    public GoodWine(Item item) {
        super(item);
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "GoodWine{" +
                "item=" + item +
                '}';
    }
}
