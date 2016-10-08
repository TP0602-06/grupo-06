package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.arithmetic;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.ArrayList;

/**
 * Created by Andres on 01/10/2016.
 */
public abstract class AbstractArithmeticRule extends RuleImplementation {
    public AbstractArithmeticRule(ArrayList<AbstractNode> region, String value) {
        super(region, value);
    }

    protected abstract int arithmeticOperation(int operationAcumulator, AbstractNode cell);

    protected abstract int defaultIntValue();

    @Override
    public boolean isBroken() {
        return check();
    }

    @Override
    public boolean isActualBroken() {
        return check();
    }

    private boolean check() {
        int operationAcumulator = this.defaultIntValue();
        for (AbstractNode node : super.region) {
            if (node.isEmpty()) {
                continue;
            }
            operationAcumulator = this.arithmeticOperation(operationAcumulator, node);
        }
        int value = Integer.parseInt(this.value);
        return (!(value == operationAcumulator));
    }
}
