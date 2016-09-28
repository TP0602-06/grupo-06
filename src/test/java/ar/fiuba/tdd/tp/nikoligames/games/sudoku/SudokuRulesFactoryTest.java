package ar.fiuba.tdd.tp.nikoligames.games.sudoku;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.*;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.CellFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SudokuRulesFactoryTest {
    @Test
    public void testSolvedBoard() {
        Board board = this.createSolvedBoard();

        SudokuRulesFactory rulesFactory = new SudokuRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        assertEquals(false, this.isBorken(rules));
    }

    @Test
    public void testNoDuplicatesInColumnRule() {
        Board board = this.createSolvedBoard();
        SudokuRulesFactory rulesFactory = new SudokuRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        AbstractCell cell = this.getCell(board, 0, 0);
        this.setValue(board, 0, 1, cell.getValue());

        assertEquals(true, this.isBorken(rules));
    }

    @Test
    public void testNoDuplicatesInRowRule() {
        Board board = this.createSolvedBoard();
        SudokuRulesFactory rulesFactory = new SudokuRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        AbstractCell cell = this.getCell(board, 0, 0);
        this.setValue(board, 1, 0, cell.getValue());

        assertEquals(true, this.isBorken(rules));
    }

    @Test
    public void testNoDuplicatesInRegionRule() {
        Board board = this.createSolvedBoard();
        SudokuRulesFactory rulesFactory = new SudokuRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        AbstractCell cell = this.getCell(board, 0, 0);
        this.setValue(board, 1, 1, cell.getValue());

        assertEquals(true, this.isBorken(rules));
    }

    private Board createSolvedBoard() {
        Board board = new Board(9, 9);
        this.setRow(board, 0, new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        this.setRow(board, 1, new String[]{"4", "5", "6", "7", "8", "9", "1", "2", "3"});
        this.setRow(board, 2, new String[]{"7", "8", "9", "1", "2", "3", "4", "5", "6"});
        this.setRow(board, 3, new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "1"});
        this.setRow(board, 4, new String[]{"5", "6", "7", "8", "9", "1", "2", "3", "4"});
        this.setRow(board, 5, new String[]{"8", "9", "1", "2", "3", "4", "5", "6", "7"});
        this.setRow(board, 6, new String[]{"3", "4", "5", "6", "7", "8", "9", "1", "2"});
        this.setRow(board, 7, new String[]{"6", "7", "8", "9", "1", "2", "3", "4", "5"});
        this.setRow(board, 8, new String[]{"9", "1", "2", "3", "4", "5", "6", "7", "8"});
        return board;
    }

    private void setRow(Board board, int row, String[] values) {
        CellFactory cellFactory = new CellFactory();
        for (int column = 0; column < 9; column++) {
            board.setCell(column, row, cellFactory.createCell(values[column]));
        }
    }

    private AbstractCell getCell(Board board, int column, int row) {
        Position position = new Position(column, row);
        return board.getCell(position);
    }

    private void setValue(Board board, int column, int row, String value) {
        Position position2 = new Position(column, row);
        board.setCellValue(position2, value);
    }

//    private AbstractCell createCell(String value) {
//        Cell cell = new Cell();
//        cell.setValue(value);
//        return cell;
//    }

    private boolean isBorken(Iterable<Rule> rules) {
        for (Rule rule : rules) {
            if (rule.isBroken()) {
                return true;
            }
        }
        return false;
    }
}
