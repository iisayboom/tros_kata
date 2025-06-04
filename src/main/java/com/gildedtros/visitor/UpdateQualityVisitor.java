package com.gildedtros.visitor;

import com.gildedtros.item_types.*;

public class UpdateQualityVisitor implements ItemVisitor {

    private final RegularItemQualityUpdater regular = new RegularItemQualityUpdater();
    private final GoodWineQualityUpdater goodWine = new GoodWineQualityUpdater();
    private final BackstagePassesQualityUpdater backstagePasses = new BackstagePassesQualityUpdater();
    private final SmellyItemQualityUpdater smellyItem = new SmellyItemQualityUpdater();
    private final LegendaryItemQualityUpdater legendaryItem = new LegendaryItemQualityUpdater();

    @Override
    public void visit(GoodWine item) {
        goodWine.update(item);
    }

    @Override
    public void visit(BackstagePasses item) {
        backstagePasses.update(item);
    }

    @Override
    public void visit(SmellyItem item) {
        smellyItem.update(item);
    }

    @Override
    public void visit(LegendaryItem item) {
        legendaryItem.update(item);
    }

    @Override
    public void visit(RegularItem item) {
        regular.update(item);
    }
}
