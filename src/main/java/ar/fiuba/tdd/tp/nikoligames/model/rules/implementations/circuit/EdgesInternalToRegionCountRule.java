package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.List;

/**
 * Responsibilities:
 * 1. Checks the quantity of edges on a region
 *
 */
public class EdgesInternalToRegionCountRule extends RuleImplementation {
    private final int countRule;

    @SuppressWarnings("CPD-START")

    public EdgesInternalToRegionCountRule(List<AbstractNode> region, String value) {
        super(region, value);
        countRule = Integer.parseInt(value);

    }

    @SuppressWarnings("CPD-END")

    @Override
    public boolean isBroken() {
        int count = getInternalEdgesCount();
        return (count != countRule);
    }

    @Override
    public boolean isActualBroken() {
        int count = getInternalEdgesCount();
        return (count > countRule);
    }

    public int getInternalEdgesCount() {
        int undirectedEdgesCount = 0;

        for (int i = 0; i < region.size(); i++) {
            for (int j = i + 1; j < region.size(); j++) {
                AbstractNode node1 = region.get(i);
                AbstractNode node2 = region.get(j);
                List<AbstractNode> node1Edgelist = node1.getEdgeList();
                List<AbstractNode> node2Edgelist = node2.getEdgeList();
                if (node1Edgelist.contains(node2) && node2Edgelist.contains(node1)) {
                    undirectedEdgesCount++;
                }
            }
        }

        return undirectedEdgesCount;
    }
}
