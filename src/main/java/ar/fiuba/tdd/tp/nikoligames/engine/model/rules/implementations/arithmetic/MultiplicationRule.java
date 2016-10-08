package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.arithmetic;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class MultiplicationRule extends AbstractArithmeticRule {

    int value = 1;

    public MultiplicationRule(ArrayList<AbstractNode> nodes, String value) {
        super(nodes, value);
    }

    protected int arithmeticOperation(int operationAcumulator, AbstractNode node) {
        operationAcumulator = operationAcumulator * Integer.parseInt(node.getValue());
        return operationAcumulator;
    }


    protected int defaultIntValue() {
        return value;
    }

}
