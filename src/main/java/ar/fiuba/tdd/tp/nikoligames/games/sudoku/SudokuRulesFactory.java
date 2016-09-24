package ar.fiuba.tdd.tp.nikoligames.games.sudoku;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.NoDuplicatesRule;

import java.util.ArrayList;

// Fabrica de reglas Sudoku. Contruye el conjunto de reglas para un juego del tipo Sudoku.
public class SudokuRulesFactory {
    //TODO: Estos valores pueden ser necesarios en otro lado, ver bien donde se pueden ubicar
    private static final int BOARD_COLUMN_SIZE = 9;
    private static final int BOARD_ROW_SIZE = 9;
    private static final int REGION_COLUMN_SIZE = 3;
    private static final int REGION_ROW_SIZE = 3;

    private Board board;

    public SudokuRulesFactory(Board board) {
        this.board = board;
    }

    public Iterable<Rule> getRules() {
        ArrayList<Rule> rules = new ArrayList<>();
        this.addColumnsRules(rules);
        this.addRowsRules(rules);
        this.addRegionsRules(rules);
        return rules;
    }

    private void addColumnsRules(ArrayList<Rule> rules) {
        for (int column = 0; column < BOARD_COLUMN_SIZE; column++) {
            rules.add(new NoDuplicatesRule(board.getColumn(column)));
        }
    }

    private void addRowsRules(ArrayList<Rule> rules) {
        for (int row = 0; row < BOARD_ROW_SIZE; row++) {
            rules.add(new NoDuplicatesRule(board.getRow(row)));
        }
    }

    private void addRegionsRules(ArrayList<Rule> rules) {
        for (int regionColumn = 0; regionColumn < REGION_COLUMN_SIZE; regionColumn++) {
            for (int regionRow = 0; regionRow < REGION_ROW_SIZE; regionRow++) {
                rules.add(new NoDuplicatesRule(this.getRegion(regionColumn, regionRow)));
            }
        }
    }

    private Iterable<Cell> getRegion(int regionColumn, int regionRow) {
        return board.getRange(this.getFirstColumnOfRegion(regionColumn),
                this.getLastColumnOfRegion(regionColumn),
                this.getFirstRowOfRegion(regionRow),
                this.getLastRowOfRegion(regionRow));
    }

    private int getFirstColumnOfRegion(int column) {
        return column * REGION_COLUMN_SIZE;
    }

    private int getLastColumnOfRegion(int column) {
        return this.getFirstColumnOfRegion(column) + 2;
    }

    private int getFirstRowOfRegion(int column) {
        return column * REGION_ROW_SIZE;
    }

    private int getLastRowOfRegion(int column) {
        return this.getFirstRowOfRegion(column) + 2;
    }
}
