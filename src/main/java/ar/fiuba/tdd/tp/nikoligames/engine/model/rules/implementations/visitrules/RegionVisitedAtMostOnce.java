package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.visitrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/8/2016.
 */
public class RegionVisitedAtMostOnce extends RuleImplementation {

    public RegionVisitedAtMostOnce(List<AbstractNode> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        int inOrOutEdgesCount = getInOrOutEdgesCount();
        if ((inOrOutEdgesCount == 2) || (inOrOutEdgesCount == 0)) {
            return false;
        }
        return true;
    }

    private int getInOrOutEdgesCount() {
        int inOrOutEdgesCount = 0;
        Iterator<AbstractNode> nodeIterator = region.iterator();
        while (nodeIterator.hasNext()) {
            AbstractNode node = nodeIterator.next();
            List<AbstractNode> edgeList = node.getEdgeList();
            Iterator<AbstractNode> edgeListIterator = edgeList.iterator();
            while (edgeListIterator.hasNext()) {
                AbstractNode edgeListNextNode = edgeListIterator.next();
                if (!region.contains(edgeListNextNode)) {
                    inOrOutEdgesCount++;
                }
            }
        }
        return inOrOutEdgesCount;
    }

    @Override
    public boolean isActualBroken() {
        int inOrOutEdgesCount = getInOrOutEdgesCount();
        if ((inOrOutEdgesCount <= 2) && (inOrOutEdgesCount >= 0)) {
            return false;
        }
        return true;
    }
}
