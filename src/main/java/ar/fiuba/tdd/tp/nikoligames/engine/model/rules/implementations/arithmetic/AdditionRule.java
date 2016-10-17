package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.arithmetic;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public class AdditionRule extends AbstractArithmeticRule {

    public AdditionRule(List<AbstractNode> region, String value) {
        super(region, value);
    }

    protected int arithmeticOperation(int operationAccumulator, AbstractNode node) {
        operationAccumulator = operationAccumulator + Integer.parseInt(node.getValue());
        return operationAccumulator;
    }

}
