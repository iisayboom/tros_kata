package com.gildedtros.mapper;

import com.gildedtros.Item;
import com.gildedtros.domain.ItemType;

public class ItemTypeMapper {

    private static final String GOOD_WINE_NAME = "Good Wine";
    private static final String LEGENDARY_NAME = "B-DAWG Keychain";
    private static final String BACKSTAGE_REF_NAME = "Backstage passes for Re:Factor";
    private static final String BACKSTAGE_HAXX_NAME = "Backstage passes for HAXX";

    private ItemTypeMapper() {}

    public static ItemType map(Item raw) {
        String name = raw.name;
        return switch (name) {
            case LEGENDARY_NAME -> ItemType.LEGENDARY;
            case GOOD_WINE_NAME -> ItemType.GOOD_WINE;
            case BACKSTAGE_REF_NAME -> ItemType.BACKSTAGE_REF;
            case BACKSTAGE_HAXX_NAME -> ItemType.BACKSTAGE_HAXX;
            default -> ItemType.NORMAL;
        };

    }
}
