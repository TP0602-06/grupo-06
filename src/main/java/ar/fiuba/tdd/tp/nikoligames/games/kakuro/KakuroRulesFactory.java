package ar.fiuba.tdd.tp.nikoligames.games.kakuro;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.NoDuplicatesRule;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Fabrica de reglas Kakuro. Contruye el conjunto de reglas para un juego del tipo Kakuro.
 */
public class KakuroRulesFactory {
    private Board board;

    public KakuroRulesFactory(Board board) {
        this.board = board;
    }

    public Iterable<Rule> getRules() {
        ArrayList<Rule> rules = new ArrayList<>();
        return rules;
    }

    private Collection<Rule> getColumnClueRules(Integer clue, int firstColumn, int lastColumn, int row) {
        return this.getClueRules(clue, this.getCells(firstColumn, lastColumn, row, row));
    }

    private Collection<Rule> getRowClueRules(Integer clue, int column, int firstRow, int lastRow) {
        return this.getClueRules(clue, this.getCells(column, column, firstRow, lastRow));
    }

    private Collection<Rule> getClueRules(Integer clue, ArrayList<AbstractCell> cells) {
        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(new AdditionRule(clue, cells));
        rules.add(new NoDuplicatesRule(cells));
        return rules;
    }

    private ArrayList<AbstractCell> getCells(int firstColumn, int lastColumn, int firstRow, int lastRow) {
        ArrayList<Position> positions = this.getPositions(firstColumn, lastColumn, firstRow, lastRow);
        return this.board.getArrayOfCells(positions);
    }

    private ArrayList<Position> getPositions(int firstColumn, int lastColumn, int firstRow, int lastRow) {
        ArrayList<Position> positions = new ArrayList<>();
        for (int column = firstColumn; column <= lastColumn; column++) {
            for (int row = firstRow; row <= lastRow; row++) {
                positions.add(new Position(column, row));
            }
        }
        return positions;
    }
}
