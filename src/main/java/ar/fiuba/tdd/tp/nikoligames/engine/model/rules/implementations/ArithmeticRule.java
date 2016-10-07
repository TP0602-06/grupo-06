package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.ArrayList;

/**
 * Created by Andres on 01/10/2016.
 */
public abstract class ArithmeticRule extends RuleImplementation {
    public ArithmeticRule(ArrayList<AbstractNode> region, String value) {
        super(region, value);
    }

    protected abstract int arithmeticOperation(int operationAcumulator, AbstractNode cell);

    protected abstract int defaultIntValue();

    @Override
    public boolean isBroken() {
        int operationAcumulator = this.defaultIntValue();
        for (AbstractNode node : super.region) {
            if (node.isEmpty()) {
                return true;
            }
            operationAcumulator = this.arithmeticOperation(operationAcumulator, node);
        }
        int value = Integer.parseInt(this.value);
        return (!(value == operationAcumulator));
    }
}
