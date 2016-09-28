package ar.fiuba.tdd.tp.nikoligames.games.sudoku;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.*;
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
    public void testEmptyBoard() {
        //TODO: Ver si hace falta crear un SudokuBoard que garantice que es de 9x9
        Board board = this.createEmptyBoard();

        //TODO: Ver si hace falta hacer un singleton
        SudokuRulesFactory rulesFactory = new SudokuRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        //TODO: Ver como ejecutar la regla
        assertEquals(true, this.isBorken(rules));
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

    private Board createEmptyBoard() {
        Board board = new Board(9, 9);
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                board.setCell(column, row, new NullCell());
            }
        }
        return board;
    }

    private Board createSolvedBoard() {
        Board board = new Board(9, 9);
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                board.setCell(column, row, this.createCell("0"));
            }
        }
        return board;
    }

    private AbstractCell getCell(Board board, int column, int row) {
        Position position = new Position(column, row);
        return board.getCell(position);
    }

    private void setValue(Board board, int column, int row, String value) {
        Position position2 = new Position(column, row);
        board.setCellValue(position2, value);
    }

    private AbstractCell createCell(String value) {
        Cell cell = new Cell();
        cell.setValue(value);
        return cell;
    }

    private boolean isBorken(Iterable<Rule> rules) {
        for (Rule rule : rules) {
            if (rule.isBroken())
                return true;
        }
        return false;
    }
}
