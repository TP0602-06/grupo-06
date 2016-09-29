package ar.fiuba.tdd.tp.nikoligames.games.sudoku;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.NoDuplicatesRule;

import java.util.ArrayList;

/**
 * Fabrica de reglas Sudoku. Contruye el conjunto de reglas para un juego del tipo Sudoku.
 */
public class SudokuRulesFactory {
    private static final int REGION_COLUMN_SIZE = 3;
    private static final int REGION_ROW_SIZE = 3;

    private Board board;

    public SudokuRulesFactory(Board board) {
        this.board = board;
    }

    public ArrayList<Rule> getRules() {
        ArrayList<Rule> rules = new ArrayList<>();
        this.addColumnsRules(rules);
        this.addRowsRules(rules);
        this.addRegionsRules(rules);
        return rules;
    }

    private void addColumnsRules(ArrayList<Rule> rules) {
        for (int boardColumn = 0; boardColumn < this.board.getCols(); boardColumn++) {
            ArrayList<AbstractCell> cells = this.getColumnCells(boardColumn);
            NoDuplicatesRule rule = new NoDuplicatesRule(cells);
            rules.add(rule);
        }
    }

    private void addRowsRules(ArrayList<Rule> rules) {
        for (int boardRow = 0; boardRow < this.board.getRows(); boardRow++) {
            ArrayList<AbstractCell> cells = this.getRowCells(boardRow);
            NoDuplicatesRule rule = new NoDuplicatesRule(cells);
            rules.add(rule);
        }
    }

    private void addRegionsRules(ArrayList<Rule> rules) {
        for (int regionColumn = 0; regionColumn < REGION_COLUMN_SIZE; regionColumn++) {
            for (int regionRow = 0; regionRow < REGION_ROW_SIZE; regionRow++) {
                ArrayList<AbstractCell> cells = this.getRegionCells(regionColumn, regionRow);
                NoDuplicatesRule rule = new NoDuplicatesRule(cells);
                rules.add(rule);
            }
        }
    }

    private ArrayList<AbstractCell> getColumnCells(int boardColumn) {
        ArrayList<Position> positions = this.getColumnPositions(boardColumn);
        return this.board.getArrayOfCells(positions);
    }

    private ArrayList<AbstractCell> getRowCells(int boardRow) {
        ArrayList<Position> positions = this.getRowPositions(boardRow);
        return this.board.getArrayOfCells(positions);
    }

    private ArrayList<AbstractCell> getRegionCells(int regionColumn, int regionRow) {
        ArrayList<Position> positions = this.getRegionPositions(regionColumn, regionRow);
        return this.board.getArrayOfCells(positions);
    }

    private ArrayList<Position> getColumnPositions(int boardColumn) {
        ArrayList<Position> positions = new ArrayList<>();
        for (int boardRow = 0; boardRow < this.board.getRows(); boardRow++) {
            positions.add(new Position(boardColumn, boardRow));
        }
        return positions;
    }

    private ArrayList<Position> getRowPositions(int boardRow) {
        ArrayList<Position> positions = new ArrayList<>();
        for (int boardColumn = 0; boardColumn < this.board.getCols(); boardColumn++) {
            positions.add(new Position(boardColumn, boardRow));
        }
        return positions;
    }

    private ArrayList<Position> getRegionPositions(int regionColumn, int regionRow) {
        ArrayList<Position> positions = new ArrayList<>();
        int firstBoardColumn = this.getFirstColumnOfRegion(regionColumn);
        int lastBoardColumn = this.getLastColumnOfRegion(regionColumn);
        int firstBoardRow = this.getFirstRowOfRegion(regionRow);
        int lastBoardRow = this.getLastRowOfRegion(regionRow);
        for (int boardColumn = firstBoardColumn; boardColumn <= lastBoardColumn; boardColumn++) {
            for (int boardRow = firstBoardRow; boardRow <= lastBoardRow; boardRow++) {
                positions.add(new Position(boardColumn, boardRow));
            }
        }
        return positions;
    }

    private int getFirstColumnOfRegion(int regionColumn) {
        return regionColumn * REGION_COLUMN_SIZE;
    }

    private int getLastColumnOfRegion(int regionColumn) {
        return this.getFirstColumnOfRegion(regionColumn) + 2;
    }

    private int getFirstRowOfRegion(int regionRow) {
        return regionRow * REGION_ROW_SIZE;
    }

    private int getLastRowOfRegion(int regionRow) {
        return this.getFirstRowOfRegion(regionRow) + 2;
    }
}
