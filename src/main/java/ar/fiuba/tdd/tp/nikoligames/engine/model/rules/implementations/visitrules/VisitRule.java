package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.visitrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.List;

/**
 * Created by Andres on 08/10/2016.
 */
public abstract class VisitRule extends RuleImplementation {

    public VisitRule(List<AbstractNode> region, String value) {
        super(region, value);
    }

    protected boolean isVisited(AbstractNode node) {
        List<AbstractNode> edgeList = node.getEdgeList();
        int size = edgeList.size();
        if (size == 0) {
            return false;
        } else {
            return true;
        }
    }

}
