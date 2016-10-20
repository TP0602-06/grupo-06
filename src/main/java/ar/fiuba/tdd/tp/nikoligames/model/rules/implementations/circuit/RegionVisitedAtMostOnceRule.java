package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.List;

/**
 * Responsibilities:
 * 1. Checks each node of the region is visited as much as once
 *
 */
public class RegionVisitedAtMostOnceRule extends RuleImplementation {

    public RegionVisitedAtMostOnceRule(List<AbstractNode> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        int inOrOutEdgesCount = getExternalEdgesCount();
        return !((inOrOutEdgesCount == 0) || (inOrOutEdgesCount == 2));
    }

    @Override
    public boolean isActualBroken() {
        int inOrOutEdgesCount = getExternalEdgesCount();
        return !((inOrOutEdgesCount >= 0) && (inOrOutEdgesCount <= 2));
    }

    public int getExternalEdgesCount() {
        int externalEdgesCount = 0;
        for (AbstractNode node : region) {
            for (AbstractNode nextNode : node.getEdgeList()) {
                if (isExternalToRegion(nextNode)) {
                    externalEdgesCount++;
                }
            }
        }
        return externalEdgesCount;
    }

    boolean isExternalToRegion(AbstractNode node) {
        return (!(super.region.contains(node)));
    }
}
