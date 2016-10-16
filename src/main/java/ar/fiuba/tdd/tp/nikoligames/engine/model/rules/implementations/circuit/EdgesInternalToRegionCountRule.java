package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.List;

/**
 * Responsabilidades:
 * Contar la cantidad de aristas internas a la region, para Slitherlink debe ser una region de 4 nodos de una celda.
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
        return (count <= countRule);
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
