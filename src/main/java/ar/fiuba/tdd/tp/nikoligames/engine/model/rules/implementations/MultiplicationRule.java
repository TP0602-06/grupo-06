package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.Coordinates;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleDefinitionValidator;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class MultiplicationRule extends RuleImplementation {
    public MultiplicationRule(ArrayList<Coordinates> region, String value) {
        super(region, value);
    }
    @Override
    public String getDefinition() {
        return RuleDefinitionValidator.MULTIPLICATION;
    }
    @Override
    public boolean isBroken(Board board) {
        Integer multiplication = 1;
        for (Coordinates position : super.region) {
            Cell cell = board.getCell(position);
            if (cell.isEmpty()) {
                return true;
            }
            multiplication *= Integer.parseInt(cell.getValue());
        }
        return (!this.value.equals(multiplication));

    }
}
