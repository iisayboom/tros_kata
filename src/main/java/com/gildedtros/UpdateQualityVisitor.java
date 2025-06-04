package com.gildedtros;

import com.gildedtros.item_types.*;
import com.gildedtros.visitor.ItemVisitor;

public class UpdateQualityVisitor implements ItemVisitor {

    @Override
    public void visit(GoodWine item) {
        item.decreaseSellInByOne();
        item.increaseQuality(item.getSellIn() < 0 ? 2 : 1);
    }

    @Override
    public void visit(BackstagePasses item) {
        item.decreaseSellInByOne();
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        } else if (item.getSellIn() < 5) {
            item.increaseQuality(3);
        } else if (item.getSellIn() < 10) {
            item.increaseQuality(2);
        } else {
            item.increaseQuality(1);
        }
    }

    @Override
    public void visit(DeprecatedItem item) {
        item.decreaseSellInByOne();
        item.setQuality(0);
    }

    @Override
    public void visit(ProgrammerItem item) {
        // Legendary items shouldn't change
    }

    @Override
    public void visit(RegularItem item) {
        item.decreaseSellInByOne();
        item.decreaseQuality(item.getSellIn() < 0 ? 2 : 1);
    }
}
