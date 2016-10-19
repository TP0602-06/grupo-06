package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.helper.VisitedHelper;
import utils.Constants;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/6/2016.
 *  Resposibilities:
 * 1. Checks there are no not visited adjcent nodes in a region.
 */
public class NoNotVisitedAdjacentNodesInSameRegionRule extends RuleImplementation {

    private final List<List<AbstractNode>> regions;

    //la region seria cada par de celda contiguas o adyacentes
    public NoNotVisitedAdjacentNodesInSameRegionRule(List<AbstractNode> region, List<List<AbstractNode>> regions) {
        super(region, Constants.EMPTY_STRING);
        this.regions = regions;
    }

    @Override
    public boolean isBroken() {

        AbstractNode node1 = region.get(0);
        AbstractNode node2 = region.get(1);
        if (!areBothNotVisited(node1, node2)) {
            return false;
        }
        //Si deja celdas contiguas sin visitar,
        Iterator<List<AbstractNode>> regionsIterator = regions.iterator();
        while (regionsIterator.hasNext()) {

            List<AbstractNode> currentRegion = regionsIterator.next();
            if (this.regionContainsAnyNode(node1, node2, currentRegion)) {
                // se rompe la regla si son de distinta region
                return (!regionContainsBothNodes(node1, node2, currentRegion));
            }
        }

        return false;
    }

    private boolean regionContainsAnyNode(AbstractNode node1, AbstractNode node2, List<AbstractNode> currentRegion) {
        return (currentRegion.contains(node1) || (currentRegion.contains(node2)));
    }

    private boolean regionContainsBothNodes(AbstractNode node1, AbstractNode node2, List<AbstractNode> currentRegion) {
        return ((currentRegion.contains(node1)) && (currentRegion.contains(node2)));
    }

    private boolean areBothNotVisited(AbstractNode node1, AbstractNode node2) {
        return (!VisitedHelper.isVisited(node1) && (!VisitedHelper.isVisited(node2)));
    }

    @Override
    public boolean isActualBroken() {
        return false;
    }


}
