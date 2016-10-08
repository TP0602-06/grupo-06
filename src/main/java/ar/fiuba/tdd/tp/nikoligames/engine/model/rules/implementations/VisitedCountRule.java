package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class VisitedCountRule extends RuleImplementation {

    public VisitedCountRule(ArrayList<AbstractNode> region, String value) {
        super(region, value);
    }

    @Override
    public boolean isBroken() {
        int count = 0;

        Iterator<AbstractNode> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            AbstractNode node = regionIterator.next();
            if (!this.isVisited(node)) {
                count++;
            }
        }
        if (count == Integer.parseInt(value)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isActualBroken() {
        return isBroken();//TODO revisar
    }

    private boolean isVisited(AbstractNode node) {
        List<AbstractNode> edgeList = node.getEdgeList();
        int size = edgeList.size();
        if (size == 0) {
            return false;
        } else {
            return true;
        }
    }
}
