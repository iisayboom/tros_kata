package com.gildedtros.visitor;

import com.gildedtros.item_types.TypedItem;

public interface QualityUpdater <T extends TypedItem> {
    void update(T Item);
}
