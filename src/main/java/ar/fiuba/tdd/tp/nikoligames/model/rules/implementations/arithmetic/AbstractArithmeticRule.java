package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.arithmetic;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;
import utils.StringToIntConverter;

import java.util.List;

/**
 * Created by Andres on 01/10/2016.
 * Responsabilites:
 * 1. Implements a rule that checks an arithmetical value with the values of the nodes in the region.
 */
public abstract class AbstractArithmeticRule extends RuleImplementation {
    private final int intValue;

    public AbstractArithmeticRule(List<AbstractNode> region, String value) {
        super(region, value);
        intValue = StringToIntConverter.parseWithDefault(value, 0);
    }

    protected abstract int arithmeticOperation(int operationAcumulator, AbstractNode cell);

    protected abstract int defaultIntValue();

    @Override
    public boolean isBroken() {
        return (intValue != getCount());
    }

    @Override
    public boolean isActualBroken() {

        return (getCount() > intValue);
    }

    private int getCount() {
        int operationAcumulator = this.defaultIntValue();
        for (AbstractNode node : super.region) {
            if (node.isEmpty()) {
                continue;
            }
            operationAcumulator = this.arithmeticOperation(operationAcumulator, node);
        }

        return operationAcumulator;
    }
}
