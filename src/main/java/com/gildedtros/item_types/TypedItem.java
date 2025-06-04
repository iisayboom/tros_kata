package com.gildedtros.item_types;

import com.gildedtros.domain.Item;
import com.gildedtros.visitor.ItemVisitor;

public abstract class TypedItem {
    protected final Item item;

    public TypedItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public String getName() {
        return item.name;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public void setSellIn(int sellIn) {
        item.sellIn = sellIn;
    }

    public int getQuality() {
        return item.quality;
    }

    public void setQuality(int quality) {
        item.quality = Math.max(0, Math.min(50, quality));
    }

    public void decreaseSellInByOne() {
        setSellIn(getSellIn() - 1);
    }

    public void decreaseQuality(int amount) {
        setQuality(getQuality() - amount);
    }

    public void increaseQuality(int amount) {
        setQuality(getQuality() + amount);
    }

    public abstract void accept(ItemVisitor visitor);
}
