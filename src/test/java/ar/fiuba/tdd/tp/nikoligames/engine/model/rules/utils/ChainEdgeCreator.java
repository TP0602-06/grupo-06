package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.List;

/**
 * Created by german on 10/14/2016.
 */
public class ChainEdgeCreator {
    public static void createChain(List<AbstractNode> region, int firstIndex, int lastIndex) {
        for (int currentIndex = firstIndex; currentIndex <= lastIndex - 1; currentIndex++) {
            AbstractNode node = region.get(currentIndex);
            AbstractNode edge = region.get(currentIndex + 1);
            node.addEdge(edge);
            edge.addEdge(node);
        }
    }
}
