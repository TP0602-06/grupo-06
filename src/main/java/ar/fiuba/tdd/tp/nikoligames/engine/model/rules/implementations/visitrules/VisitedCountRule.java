package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.visitrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by german on 10/6/2016.
 */
public class VisitedCountRule extends VisitRule {

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


}
