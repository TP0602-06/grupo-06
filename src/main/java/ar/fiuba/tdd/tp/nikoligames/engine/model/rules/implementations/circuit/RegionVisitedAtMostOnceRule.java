package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.Iterator;
import java.util.List;

/**
 * Responsabilidades: verifica que cada nodo de la region sea visitado como mucho una vez por el circuito.
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
