package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/14/2016.
 */
public class EdgeCreator {
    public static void addExternalEdge(AbstractNode nodeInRegion2) {
        AbstractNode externalNode2 = new ConcreteNode("", false);
        nodeInRegion2.addEdge(externalNode2);
    }

    public static void addUndirectedEdgesBetweenNodeAndEachNodeFromList(AbstractNode node, List<AbstractNode> edges) {
        Iterator<AbstractNode> iterator = edges.iterator();
        while (iterator.hasNext()) {
            AbstractNode connectedNode = iterator.next();
            node.addEdge(connectedNode);
            connectedNode.addEdge(node);
        }
    }
}
