package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import utils.Constants;

import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class AdjacentRule extends AbstractRegionRule {

    private List<AbstractNode> adjacentNodes;

    @SuppressWarnings("CPD-START")

    public AdjacentRule(List<AbstractNode> region, List<AbstractNode> adjacentNodes) {
        super(region, Constants.EMPTY_STRING);
        this.adjacentNodes = adjacentNodes;
    }

    @SuppressWarnings("CPD-END")

    @Override
    protected boolean nodeCondition(AbstractNode node) {
        List<AbstractNode> edgeList = node.getEdgeList();
        return (!adjacentNodes.containsAll(edgeList));
    }

    @Override
    public boolean isActualBroken() {
        return isBroken();
    }
}
