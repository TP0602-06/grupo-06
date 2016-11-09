package ar.fiuba.tdd.tp.nikoligames.model.rules.utils;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;

import java.util.List;

/**
 * Created by german on 10/14/2016.
 */
public class ChainEdgeCreator {
    public static void createChain(List<AbstractNode> region, int firstIndex, int lastIndex) {
        for (int currentIndex = firstIndex; currentIndex <= lastIndex - 1; currentIndex++) {
            AbstractNode node = region.get(currentIndex);
            AbstractNode edge = region.get(currentIndex + 1);
            ChainEdgeCreator.addEdge(node, edge);
        }
    }

    public static void createCycle(List<AbstractNode> region, int firstIndex, int lastIndex) {
        for (int currentIndex = firstIndex; currentIndex <= lastIndex; currentIndex++) {
            AbstractNode node = region.get(currentIndex);
            AbstractNode edge = ChainEdgeCreator.getNextNodeInCycle(region, firstIndex, currentIndex,lastIndex);
            ChainEdgeCreator.addEdge(node, edge);
        }
    }

    private static AbstractNode getNextNodeInCycle(List<AbstractNode> region, int firstIndex, int currentIndex, int lastIndex) {
        if (currentIndex == lastIndex) {
            return region.get(firstIndex);
        } else {
            return region.get(currentIndex + 1);
        }
    }

    private static void addEdge(AbstractNode node, AbstractNode edge) {
        node.addEdge(edge);
        edge.addEdge(node);
    }
}
