package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.arithmetic;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public class MultiplicationRule extends AbstractArithmeticRule {

    private static int DEFAULT_OPERATION_VALUE = 1;

    public MultiplicationRule(List<AbstractNode> nodes, String value) {
        super(nodes, value);
    }

    protected int arithmeticOperation(int operationAccumulator, AbstractNode node) {
        operationAccumulator = operationAccumulator * Integer.parseInt(node.getValue());
        return operationAccumulator;
    }

    @Override
    protected int defaultIntValue() {
        return DEFAULT_OPERATION_VALUE;
    }

}
