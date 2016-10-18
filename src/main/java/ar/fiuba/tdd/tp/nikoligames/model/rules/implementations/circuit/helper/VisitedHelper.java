package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.helper;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;

import java.util.List;

/**
 * Created by Andres on 08/10/2016.
 */
public class VisitedHelper {

    public static boolean isVisited(AbstractNode node) {
        //OJo que sirve solo para un grafo NO dirigido
        List<AbstractNode> edgeList = node.getEdgeList();
        int size = edgeList.size();
        if (size == 0) {
            return false;
        } else {
            return true;
        }
    }

}
