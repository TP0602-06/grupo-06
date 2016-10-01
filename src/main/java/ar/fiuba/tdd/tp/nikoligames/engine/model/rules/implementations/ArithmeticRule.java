package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;

/**
 * Created by Andres on 01/10/2016.
 */
public abstract class ArithmeticRule extends RuleImplementation {
    public ArithmeticRule(ArrayList<Position> region, String value) {
        super(region, value);
    }

    protected abstract int arithmeticOperation(int operationAcumulator, Cell cell);

    protected abstract int defaultIntValue();

    @Override
    public boolean isBroken(Board board) {
        int operationAcumulator = this.defaultIntValue();
        for (Position position : super.region) {
            Cell cell = board.getCell(position);
            if (cell.isEmpty()) {
                return true;
            }
            this.arithmeticOperation(operationAcumulator, cell);
        }
        int value = Integer.parseInt(this.value);
        return (!(value == operationAcumulator));
    }
}
