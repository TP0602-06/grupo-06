package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.visitrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

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
