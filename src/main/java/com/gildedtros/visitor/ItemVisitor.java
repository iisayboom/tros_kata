package com.gildedtros.visitor;

import com.gildedtros.item_types.*;

public interface ItemVisitor {
    void visit(BackstagePasses item);
    void visit(GoodWine item);
    void visit(SmellyItem item);
    void visit(LegendaryItem item);
    void visit(RegularItem item);
}
