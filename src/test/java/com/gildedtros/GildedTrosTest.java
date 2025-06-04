package com.gildedtros;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GildedTrosTest {

    @Test
    void normalItem_decreasesSellInAndQuality() {
        Item item = new Item("Normal Item", 10, 20);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(19);
    }

    @Test
    void normalItem_degradesTwiceAsFastAfterSellIn() {
        Item item = new Item("Normal Item", 0, 10);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void qualityNeverNegative() {
        Item item = new Item("Normal Item", 5, 0);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void goodWine_increasesInQuality() {
        Item item = new Item("Good Wine", 5, 10);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(11);
    }

    @Test
    void goodWine_qualityNeverAbove50() {
        Item item = new Item("Good Wine", 5, 50);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void bDawgKeychain_doesNotChange() {
        Item item = new Item("B-DAWG Keychain", 0, 80);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(0);
        assertThat(item.quality).isEqualTo(80);
    }

    @Test
    void backstagePasses_increaseBy1IfMoreThan10Days() {
        Item item = new Item("Backstage passes for Re:Factor", 15, 20);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.quality).isEqualTo(21);
    }

    @Test
    void backstagePasses_increaseBy2If10DaysOrLess() {
        Item item = new Item("Backstage passes for Re:Factor", 10, 20);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.quality).isEqualTo(22);
    }

    @Test
    void backstagePasses_increaseBy3If5DaysOrLess() {
        Item item = new Item("Backstage passes for Re:Factor", 5, 20);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.quality).isEqualTo(23);
    }

    @Test
    void backstagePasses_qualityDropsTo0AfterConcert() {
        Item item = new Item("Backstage passes for Re:Factor", 0, 20);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void backstagePasses_qualityNeverAbove50() {
        Item item = new Item("Backstage passes for Re:Factor", 5, 49);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.quality).isEqualTo(50);
    }
}