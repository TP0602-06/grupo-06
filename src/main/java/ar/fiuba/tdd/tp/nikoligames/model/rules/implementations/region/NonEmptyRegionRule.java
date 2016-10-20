package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/8/2016.
 * Responsabilities:
 * 1. Checks that all nodes in a region are not empty
 */
public class NonEmptyRegionRule extends RuleImplementation {
    public NonEmptyRegionRule(List<AbstractNode> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        Iterator<AbstractNode> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            AbstractNode node = regionIterator.next();
            if (!node.isEditable()) {
                continue;
            }
            if (node.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isActualBroken() {
        return false;
    }
}
