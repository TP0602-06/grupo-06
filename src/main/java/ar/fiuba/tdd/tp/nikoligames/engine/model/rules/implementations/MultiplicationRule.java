package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleDefinitionValidator;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class MultiplicationRule extends RuleImplementation {

    public MultiplicationRule(ArrayList<Position> region, String value) {
        super(region, value);
    }

    @Override
    public boolean isBroken(Board board) {
        int multiplication = 1;
        for (Position position : super.region) {
            Cell cell = board.getCell(position);
            if (cell.isEmpty()) {
                return true;
            }
            multiplication *= Integer.parseInt(cell.getValue());
        }
        int value = Integer.parseInt(this.value);
        boolean result = (value == multiplication);
        return (!result);

    }
}
