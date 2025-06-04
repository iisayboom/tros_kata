package com.gildedtros.mapper;

import com.gildedtros.domain.Item;
import com.gildedtros.item_types.*;

public class ItemTypeMapper {
    public static TypedItem map(Item item) {
        switch (item.name) {
            case "Good Wine":
                return new GoodWine(item);
            case "Backstage passes for Re:Factor":
                return new BackstagePasses(item);
            case "B-DAWG Keychain":
                return new ProgrammerItem(item);
        }
        if (item.name.startsWith("Duplicate"))
            return new DeprecatedItem(item);

        return new RegularItem(item);
    }
}
