package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleDefinitionValidator;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class AdditionRule extends RuleImplementation {
    public AdditionRule(ArrayList<Position> region, String value) {
        super(region, value, RuleDefinitionValidator.SUMA);
    }
    @Override
    public boolean isBroken(Board board) {
        int addition = 0;
        for (Position position : super.region) {
            Cell cell = board.getCell(position);
            if (cell.isEmpty()) {
                return true;
            }
            addition += Integer.parseInt(cell.getValue());
        }
        int value = Integer.parseInt(this.value);
        boolean result = (value == addition);
        return (!result);
    }
}
