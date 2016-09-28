package ar.fiuba.tdd.tp.nikoligames.games.kakuro;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.*;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

public class KakuroRulesFactoryTest {
    @Test
    public void testSolvedBoard() {
        Board board = this.createSolvedBoard();

        KakuroRulesFactory rulesFactory = new KakuroRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        Assert.assertEquals(false, this.isBorken(rules));
    }

    @Test
    public void testEmptyBoard() {
        //TODO: Ver si hace falta crear un SudokuBoard que garantice que es de 9x9
        Board board = this.createEmptyBoard();

        //TODO: Ver si hace falta hacer un singleton
        KakuroRulesFactory rulesFactory = new KakuroRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        //TODO: Ver como ejecutar la regla
        Assert.assertEquals(true, this.isBorken(rules));
    }

    @Test
    public void testNoDuplicatesInColumnRule() {
        Board board = this.createSolvedBoard();
        KakuroRulesFactory rulesFactory = new KakuroRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        AbstractCell cell = this.getCell(board, 0, 1);
        this.setValue(board, 0, 2, cell.getValue());

        Assert.assertEquals(true, this.isBorken(rules));
    }

    @Test
    public void testNoDuplicatesInRowRule() {
        Board board = this.createSolvedBoard();
        KakuroRulesFactory rulesFactory = new KakuroRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        AbstractCell cell = this.getCell(board, 1, 0);
        this.setValue(board, 2, 0, cell.getValue());

        Assert.assertEquals(true, this.isBorken(rules));
    }

    @Test
    public void testAdditionInColumnRule() {
        Board board = this.createSolvedBoard();
        KakuroRulesFactory rulesFactory = new KakuroRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        AbstractCell cell = this.getCell(board, 0, 1);
        Integer value = Integer.parseInt(cell.getValue()) + 1;
        this.setValue(board, 0, 1, value.toString());

        Assert.assertEquals(true, this.isBorken(rules));
    }

    @Test
    public void testAdditionInRowRule() {
        Board board = this.createSolvedBoard();
        KakuroRulesFactory rulesFactory = new KakuroRulesFactory(board);
        Iterable<Rule> rules = rulesFactory.getRules();

        AbstractCell cell = this.getCell(board, 1, 0);
        Integer value = Integer.parseInt(cell.getValue()) + 1;
        this.setValue(board, 1, 0, value.toString());

        Assert.assertEquals(true, this.isBorken(rules));
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
