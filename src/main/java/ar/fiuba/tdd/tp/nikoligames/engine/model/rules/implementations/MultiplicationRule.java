package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.AbstractCell;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class MultiplicationRule extends ArithmeticRule {

    int value = 1;

    public MultiplicationRule(ArrayList<Node> listOfCells, String value) {
        super(listOfCells, value);
    }

    protected int arithmeticOperation(int operationAcumulator, AbstractCell cell) {
        operationAcumulator = operationAcumulator * Integer.parseInt(cell.getValue());
        return operationAcumulator;
    }


    protected int defaultIntValue() {
        return value;
    }
}
