package com.gildedtros.mapper;

import com.gildedtros.domain.Item;
import com.gildedtros.item_types.*;

public class ItemTypeMapper {
    public static TypedItem map(Item item) {
        return switch (item.name) {
            case "Good Wine" -> new GoodWine(item);
            case "Backstage passes for Re:Factor", "Backstage passes for HAXX" -> new BackstagePasses(item);
            case "B-DAWG Keychain" -> new LegendaryItem(item);
            case "Duplicate Code", "Long Methods", "Ugly Variable Names" -> new SmellyItem(item);
            default -> new RegularItem(item);
        };
    }
}
