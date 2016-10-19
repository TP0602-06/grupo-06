package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.List;

/**
 * Created by Andres on 08/10/2016.
 * Responsabilities:
 * 1. Checks a condition on a certain node.
 */
public abstract class AbstractRegionRule extends RuleImplementation {
    public AbstractRegionRule(List<AbstractNode> region, String value) {
        super(region, value);
    }

    @Override
    public boolean isBroken() {
        return region.stream().anyMatch(node -> nodeCondition(node));
    }

    protected abstract boolean nodeCondition(AbstractNode node);
}
