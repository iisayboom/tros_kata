package com.gildedtros.updater;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.ItemType;
import com.gildedtros.domain.TypedItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmellyItemUpdaterTest {
    @Test
    void smellyItem_degradesTwiceAsFastBeforeSellIn() {
        Item item = new Item("Duplicate Code", 5, 10);
        new SmellyItemUpdater().update(new TypedItem(item, ItemType.SMELLY));

        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void smellyItem_degradesFourTimesAsFastAfterSellIn() {
        Item item = new Item("Long Methods", 0, 10);
        new SmellyItemUpdater().update(new TypedItem(item, ItemType.SMELLY));

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    void smellyItem_qualityDoesNotGoBelowZero() {
        Item item = new Item("Ugly Variable Names", 0, 3);
        new SmellyItemUpdater().update(new TypedItem(item, ItemType.SMELLY));

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(0);
    }
}