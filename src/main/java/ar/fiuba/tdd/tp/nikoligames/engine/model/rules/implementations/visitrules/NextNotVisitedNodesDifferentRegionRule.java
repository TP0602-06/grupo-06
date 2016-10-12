package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.visitrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class NextNotVisitedNodesDifferentRegionRule extends RuleImplementation {

    private final List<List<AbstractNode>> regions;

    //la region seria cada par de celda contiguas o adyacentes
    public NextNotVisitedNodesDifferentRegionRule(List<AbstractNode> region, List<List<AbstractNode>> regions) {
        super(region, "");
        this.regions = regions;
    }

    @Override
    public boolean isBroken() {

        AbstractNode node1 = region.get(0);
        AbstractNode node2 = region.get(1);
        if (!areBothNotVisited(node1, node2)) {
            return false;
        }

        Iterator<List<AbstractNode>> regionsIterator = regions.iterator();
        while (regionsIterator.hasNext()) {

            List<AbstractNode> currentRegion = regionsIterator.next();
            if (this.regionContainsAnyNode(node1, node2, currentRegion)) {
                return !(regionContainsBothNodes(node1, node2, currentRegion));
            }
        }

        return false;
    }

    private boolean regionContainsAnyNode(AbstractNode node1, AbstractNode node2, List<AbstractNode> currentRegion) {
        if (currentRegion.contains(node1) || (currentRegion.contains(node2))) {
            return true;
        }
        return false;
    }

    private boolean regionContainsBothNodes(AbstractNode node1, AbstractNode node2, List<AbstractNode> currentRegion) {
        if ((currentRegion.contains(node1)) && (currentRegion.contains(node2))) {
            return true;
        }
        return false;
    }

    private boolean areBothNotVisited(AbstractNode node1, AbstractNode node2) {
        if (!VisitedHelper.isVisited(node1) && (!VisitedHelper.isVisited(node2))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isActualBroken() {
        return false;
    }


}
