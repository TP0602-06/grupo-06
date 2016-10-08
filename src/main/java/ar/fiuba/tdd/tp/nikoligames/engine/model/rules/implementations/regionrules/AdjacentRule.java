package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.regionrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class AdjacentRule extends RegionRule {

    private List<AbstractNode> adjacentNodes;

    public AdjacentRule(List<AbstractNode> region, List<AbstractNode> adjacentNodes) {
        super(region, "");
        this.adjacentNodes = adjacentNodes;
    }


    @Override
    protected boolean nodeCondition(AbstractNode node) {
        List<AbstractNode> edgeList = node.getEdgeList();
        return (!adjacentNodes.containsAll(edgeList));
    }

    @Override
    public boolean isActualBroken() {
        return isBroken();//TODO revisar
    }

}
