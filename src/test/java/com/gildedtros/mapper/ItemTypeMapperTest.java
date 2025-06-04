package com.gildedtros.mapper;

import com.gildedtros.Item;
import com.gildedtros.domain.ItemType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTypeMapperTest {
    @Test
    void mapsGoodWineToGoodWineType() {
        Item item = new Item("Good Wine", 10, 20);
        assertThat(ItemTypeMapper.map(item)).isEqualTo(ItemType.GOOD_WINE);
    }

    @Test
    void mapsLegendaryToLegendaryType() {
        Item item = new Item("B-DAWG Keychain", 0, 80);
        assertThat(ItemTypeMapper.map(item)).isEqualTo(ItemType.LEGENDARY);
    }

    @Test
    void mapsBackstageRefToBackstageRefType() {
        Item item = new Item("Backstage passes for Re:Factor", 15, 20);
        assertThat(ItemTypeMapper.map(item)).isEqualTo(ItemType.BACKSTAGE_REF);
    }

    @Test
    void mapsBackstageHaxxToBackstageHaxxType() {
        Item item = new Item("Backstage passes for HAXX", 12, 30);
        assertThat(ItemTypeMapper.map(item)).isEqualTo(ItemType.BACKSTAGE_HAXX);
    }

    @Test
    void mapsUnknownToNormalType() {
        Item item = new Item("Some Random Item", 5, 5);
        assertThat(ItemTypeMapper.map(item)).isEqualTo(ItemType.NORMAL);
    }
}