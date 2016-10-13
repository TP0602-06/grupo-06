package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.List;

/**
 * Created by german on 10/8/2016.
 */
public class NoCircuitsRule extends RuleImplementation {
    public NoCircuitsRule(List<AbstractNode> region, String value) {
        super(region, value);
    }

    @Override
    public boolean isBroken() {
        return false;
    }

    @Override
    public boolean isActualBroken() {
        return false;
    }
}
