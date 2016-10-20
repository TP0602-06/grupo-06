package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.List;

/**
 * Responsibilities:
 * 1. Checks that a node has a certain number of edges.
 */
public class NodeEdgelistCountRule extends RuleImplementation {
    private int countRule;

    public NodeEdgelistCountRule(List<AbstractNode> region, String value) {
        super(region, value);
        countRule = Integer.parseInt(value);
    }

    @Override
    public boolean isBroken() {
        int edgeListSize = getEdgeListSize();
        return (edgeListSize != countRule);
    }

    private int getEdgeListSize() {
        AbstractNode node = region.get(0);
        List<AbstractNode> edgelist = node.getEdgeList();
        return edgelist.size();
    }

    @Override
    public boolean isActualBroken() {
        int edgeListSize = getEdgeListSize();
        if (edgeListSize <= countRule) {
            return false;
        }
        return true;
    }
}
