package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class MultiplicationRule extends ArithmeticRule {
    private static final int defaultValue = 1;

    public MultiplicationRule(ArrayList<Position> region, String value) {
        super(region, value);
    }



    protected int arithmeticOperation(int operationAcumulator, Cell cell) {
        int value = Integer.parseInt(this.value);
        operationAcumulator *= value;
        return operationAcumulator;
    }



    protected int defaultIntValue() {
        return defaultValue;
    }


}
