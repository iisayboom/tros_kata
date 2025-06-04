package com.gildedtros;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.ItemType;
import com.gildedtros.domain.TypedItem;
import com.gildedtros.updater.GoodWineUpdater;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GoodWineUpdaterTest {
    @Test
    void goodWine_increasesInQuality() {
        Item item = new Item("Good Wine", 5, 10);
        new GoodWineUpdater().update(new TypedItem(item, ItemType.GOOD_WINE));

        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(11);
    }

    @Test
    void goodWine_qualityNeverAbove50() {
        Item item = new Item("Good Wine", 5, 50);
        new GoodWineUpdater().update(new TypedItem(item, ItemType.GOOD_WINE));

        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(50);
    }
}