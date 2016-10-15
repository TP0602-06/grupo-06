package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.arithmetic;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.List;

/**
 * Created by Andres on 01/10/2016.
 */
public abstract class AbstractArithmeticRule extends RuleImplementation {

    protected int arithmeticValue;

    public AbstractArithmeticRule(List<AbstractNode> region, String value) {
        super(region, value);
    }

    public AbstractArithmeticRule(List<AbstractNode> region, String value, int arithmeticValue) {
        super(region, value);
        this.arithmeticValue = arithmeticValue;
    }

    protected abstract int arithmeticOperation(int operationAccumulator, AbstractNode cell);

    @Override
    public boolean isBroken() {
        return check();
    }

    @Override
    public boolean isActualBroken() {
        return check();
    }

    private boolean check() {

        region.forEach(node -> {
            if (!node.isEmpty()) {
                arithmeticValue = arithmeticOperation(arithmeticValue, node);
            }
        });

        int value = Integer.parseInt(this.value);
        return value != arithmeticValue;
    }
}
