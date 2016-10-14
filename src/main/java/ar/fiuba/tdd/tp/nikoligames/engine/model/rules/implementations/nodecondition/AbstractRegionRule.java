package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Andres on 08/10/2016.
 */
public abstract class AbstractRegionRule extends RuleImplementation {
    public AbstractRegionRule(List<AbstractNode> region, String value) {
        super(region, value);
    }

    @Override
    public boolean isBroken() {
        Iterator<AbstractNode> nodeIterator = region.iterator();
        while (nodeIterator.hasNext()) {
            AbstractNode node = nodeIterator.next();
            if (nodeCondition(node)) {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean nodeCondition(AbstractNode node);
}
