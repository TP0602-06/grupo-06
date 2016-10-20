package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.helper.VisitedHelper;

import java.util.Iterator;
import java.util.List;

/**
 * Responsabilidades:
 * 1. Checks that there is a certain quantity of visited nodes on a certain region.
 *
 */
public class RegionVisitedCountRule extends RuleImplementation {

    public RegionVisitedCountRule(List<AbstractNode> region, String value) {
        super(region, value);
    }

    @Override
    public boolean isBroken() {
        int count = getCount();
        return compareEqualsCount(count);
    }

    private int getCount() {
        int count = 0;
        Iterator<AbstractNode> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            AbstractNode node = regionIterator.next();
            if (VisitedHelper.isVisited(node)) {
                count++;
            }
        }
        return count;
    }

    private boolean compareEqualsCount(int count) {
        if (count == Integer.parseInt(value)) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public boolean isActualBroken() {
        int count = getCount();
        return compareLessOrEqualsCount(count);
    }

    private boolean compareLessOrEqualsCount(int count) {
        if (count <= Integer.parseInt(value)) {
            return false;
        } else {
            return true;
        }
    }
}
