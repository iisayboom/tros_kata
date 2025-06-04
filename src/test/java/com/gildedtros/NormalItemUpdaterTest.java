package com.gildedtros;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.ItemType;
import com.gildedtros.domain.TypedItem;
import com.gildedtros.updater.NormalItemUpdater;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NormalItemUpdaterTest {
    @Test
    void normalItem_degradesBy1BeforeSellIn() {
        Item item = new Item("Normal Item", 10, 20);
        new NormalItemUpdater().update(new TypedItem(item, ItemType.NORMAL));

        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(19);
    }

    @Test
    void normalItem_degradesBy2AfterSellIn() {
        Item item = new Item("Normal Item", 0, 20);
        new NormalItemUpdater().update(new TypedItem(item, ItemType.NORMAL));

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(18);
    }

    @Test
    void normalItem_qualityNeverBelowZero() {
        Item item = new Item("Normal Item", 0, 0);
        new NormalItemUpdater().update(new TypedItem(item, ItemType.NORMAL));

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(0);
    }
}