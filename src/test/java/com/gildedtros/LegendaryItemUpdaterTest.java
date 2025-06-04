package com.gildedtros;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.ItemType;
import com.gildedtros.domain.TypedItem;
import com.gildedtros.updater.LegendaryItemUpdater;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LegendaryItemUpdaterTest {
    @Test
    void legendaryItem_neverChanges() {
        Item item = new Item("B-DAWG Keychain", 0, 80);
        new LegendaryItemUpdater().update(new TypedItem(item, ItemType.LEGENDARY));

        assertThat(item.sellIn).isEqualTo(0);
        assertThat(item.quality).isEqualTo(80);
    }
}