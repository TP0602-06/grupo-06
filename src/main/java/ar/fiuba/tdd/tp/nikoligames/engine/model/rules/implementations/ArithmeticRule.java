package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.AbstractCell;

import java.util.ArrayList;

/**
 * Created by Andres on 01/10/2016.
 */
public abstract class ArithmeticRule extends RuleImplementation {
    public ArithmeticRule(ArrayList<AbstractCell> listOfCells, String value) {
        super(listOfCells, value);
    }

    protected abstract int arithmeticOperation(int operationAcumulator, AbstractCell cell);

    protected abstract int defaultIntValue();

    @Override
    public boolean isBroken() {
        int operationAcumulator = this.defaultIntValue();
        for (AbstractCell cell : super.listOfCells) {
            if (cell.isEmpty()) {
                return true;
            }
            operationAcumulator = this.arithmeticOperation(operationAcumulator, cell);
        }
        int value = Integer.parseInt(this.value);
        return (!(value == operationAcumulator));
    }
}
