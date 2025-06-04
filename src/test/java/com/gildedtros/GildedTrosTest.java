package com.gildedtros;

import com.gildedtros.domain.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GildedTrosTest {

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

    @Test
    void backstageHaxx_increasesBy2If10DaysOrLess() {
        Item item = new Item("Backstage passes for HAXX", 10, 20);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.quality).isEqualTo(22);
        assertThat(item.sellIn).isEqualTo(9);
    }

    @Test
    void ringOfCleanseningCode_behavesLikeNormalItem() {
        Item item = new Item("Ring of Cleansening Code", 10, 20);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(19);
    }

    @Test
    void elixirOfSolid_behavesLikeNormalItem() {
        Item item = new Item("Elixir of the SOLID", 5, 7);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    void bDawgKeychain_negativeSellIn_doesNotChange() {
        Item item = new Item("B-DAWG Keychain", -1, 80);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(80);
    }

    @Test
    void backstageReFactor_moreThan10Days_increasesBy1() {
        Item item = new Item("Backstage passes for Re:Factor", 15, 20);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(14);
        assertThat(item.quality).isEqualTo(21);
    }

    @Test
    void backstageReFactor_10DaysLeft_increasesBy2() {
        Item item = new Item("Backstage passes for Re:Factor", 10, 49);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void backstageHaxx_5DaysLeft_increasesBy3() {
        Item item = new Item("Backstage passes for HAXX", 5, 49);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void duplicateCode_degradesBy2BeforeSellIn() {
        Item item = new Item("Duplicate Code", 3, 6);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(2);
        assertThat(item.quality).isEqualTo(4);
    }

    @Test
    void longMethods_degradesBy2BeforeSellIn() {
        Item item = new Item("Long Methods", 3, 6);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(2);
        assertThat(item.quality).isEqualTo(4);
    }

    @Test
    void uglyVariableNames_degradesBy2BeforeSellIn() {
        Item item = new Item("Ugly Variable Names", 3, 6);
        GildedTros app = new GildedTros(List.of(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(2);
        assertThat(item.quality).isEqualTo(4);
    }

}
