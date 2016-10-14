package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;

/**
 * Created by german on 10/14/2016.
 */
public class ExternalEdgeCreator {
    public static void addExternalEdge(AbstractNode nodeInRegion2) {
        AbstractNode externalNode2 = new ConcreteNode("", false);
        nodeInRegion2.addEdge(externalNode2);
    }

}
