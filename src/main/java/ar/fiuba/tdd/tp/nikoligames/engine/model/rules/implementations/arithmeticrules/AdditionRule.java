package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.arithmeticrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class AdditionRule extends ArithmeticRule {
    int value = 0;

    public AdditionRule(ArrayList<AbstractNode> region, String value) {
        super(region, value);
    }

    protected int arithmeticOperation(int operationAcumulator, AbstractNode node) {
        operationAcumulator = operationAcumulator + Integer.parseInt(node.getValue());
        return operationAcumulator;
    }


    protected int defaultIntValue() {
        return value;
    }

}
