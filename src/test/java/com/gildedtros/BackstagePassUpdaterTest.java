package com.gildedtros;

import com.gildedtros.domain.Item;
import com.gildedtros.domain.ItemType;
import com.gildedtros.domain.TypedItem;
import com.gildedtros.updater.BackstagePassUpdater;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BackstagePassUpdaterTest {
    @Test
    void backstagePass_increasesBy1WhenMoreThan10Days() {
        Item item = new Item("Backstage passes for Re:Factor", 15, 20);
        new BackstagePassUpdater().update(new TypedItem(item, ItemType.BACKSTAGE_REF));

        assertThat(item.sellIn).isEqualTo(14);
        assertThat(item.quality).isEqualTo(21);
    }

    @Test
    void backstagePass_increasesBy2When10DaysOrLess() {
        Item item = new Item("Backstage passes for Re:Factor", 10, 20);
        new BackstagePassUpdater().update(new TypedItem(item, ItemType.BACKSTAGE_REF));

        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(22);
    }

    @Test
    void backstagePass_increasesBy3When5DaysOrLess() {
        Item item = new Item("Backstage passes for Re:Factor", 5, 20);
        new BackstagePassUpdater().update(new TypedItem(item, ItemType.BACKSTAGE_REF));

        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(23);
    }

    @Test
    void backstagePass_qualityDropsToZeroAfterConcert() {
        Item item = new Item("Backstage passes for Re:Factor", 0, 20);
        new BackstagePassUpdater().update(new TypedItem(item, ItemType.BACKSTAGE_REF));

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void backstagePass_qualityNeverAbove50() {
        Item item = new Item("Backstage passes for Re:Factor", 5, 49);
        new BackstagePassUpdater().update(new TypedItem(item, ItemType.BACKSTAGE_REF));

        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(50);
    }
}