package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleDefinitionValidator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by german on 9/30/2016.
 */
public class NoDuplicatesRule extends RuleImplementation {
    public NoDuplicatesRule(ArrayList<Position> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken(Board board) {
        return checkRule(board,true);
    }

    @Override
    public boolean isActualBroken(Board board) {
        return checkRule(board,false);
    }

    private boolean checkRule(Board board,boolean emptyEqualsFail) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (Position position : super.region) {

            Cell cell = board.getCell(position);
            if (cell.isEmpty()) {
                if (emptyEqualsFail) {
                    return true;
                }
                continue;
            }
            if (values.contains(Integer.parseInt(cell.getValue()))) {
                return true;
            }
            values.add(Integer.parseInt(cell.getValue()));
        }
        return false;
    }
}
