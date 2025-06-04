package com.gildedtros.updater;

import com.gildedtros.domain.ItemType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemUpdaterFactoryTest {
    private ItemUpdaterFactory factory;

    @BeforeEach
    void setup() {
        factory = new ItemUpdaterFactory();
    }

    @Test
    void returnsCorrectUpdaterForNormal() {
        ItemUpdater updater = factory.getUpdater(ItemType.NORMAL);
        assertThat(updater).isInstanceOf(NormalItemUpdater.class);
    }

    @Test
    void returnsCorrectUpdaterForGoodWine() {
        ItemUpdater updater = factory.getUpdater(ItemType.GOOD_WINE);
        assertThat(updater).isInstanceOf(GoodWineUpdater.class);
    }

    @Test
    void returnsCorrectUpdaterForBackstageRef() {
        ItemUpdater updater = factory.getUpdater(ItemType.BACKSTAGE_REF);
        assertThat(updater).isInstanceOf(BackstagePassUpdater.class);
    }

    @Test
    void returnsCorrectUpdaterForBackstageHaxx() {
        ItemUpdater updater = factory.getUpdater(ItemType.BACKSTAGE_HAXX);
        assertThat(updater).isInstanceOf(BackstagePassUpdater.class);
    }

    @Test
    void returnsCorrectUpdaterForLegendary() {
        ItemUpdater updater = factory.getUpdater(ItemType.LEGENDARY);
        assertThat(updater).isInstanceOf(LegendaryItemUpdater.class);
    }

    @Test
    void returnsCorrectUpdaterForSmelly() {
        ItemUpdater updater = factory.getUpdater(ItemType.SMELLY);
        assertThat(updater).isInstanceOf(SmellyItemUpdater.class);
    }
}