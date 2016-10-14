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
        if ((inOrOutEdgesCount == 2) || (inOrOutEdgesCount == 0)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isActualBroken() {
        int inOrOutEdgesCount = getExternalEdgesCount();
        if ((inOrOutEdgesCount <= 2) && (inOrOutEdgesCount >= 0)) {
            return false;
        }
        return true;
    }

    public int getExternalEdgesCount() {
        int externalEdgesCount = 0;
        Iterator<AbstractNode> nodeIterator = region.iterator();
        while (nodeIterator.hasNext()) {
            AbstractNode node = nodeIterator.next();
            List<AbstractNode> edgeList = node.getEdgeList();
            Iterator<AbstractNode> edgeListIterator = edgeList.iterator();
            while (edgeListIterator.hasNext()) {
                AbstractNode edgeListNextNode = edgeListIterator.next();
                if (hasToCount(edgeListNextNode)) {
                    externalEdgesCount++;
                }
            }
        }
        return externalEdgesCount;
    }

    boolean hasToCount(AbstractNode node) {
        return (!(super.region.contains(node)));
    }
}
