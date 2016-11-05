package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.List;

/**
 * Created by matias on 05/11/16.
 */
public abstract class RegionAbstractRule extends RuleImplementation {
    public RegionAbstractRule(List<AbstractNode> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        return this.check();
    }

    @Override
    public boolean isActualBroken() {
        return this.check();
    }

    protected abstract boolean check();
}
