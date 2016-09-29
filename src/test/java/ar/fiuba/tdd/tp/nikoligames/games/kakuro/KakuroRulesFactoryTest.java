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

    private Board createSolvedBoard() {
        Board board = new Board(4, 4);
        board.setCell(0, 0, new NonEditableCell("15\\6"));
        board.setCell(0, 1, new EditableCell("1"));
        board.setCell(0, 2, new EditableCell("2"));
        board.setCell(0, 3, new EditableCell("3"));
        board.setCell(1, 0, new EditableCell("4"));
        board.setCell(2, 0, new EditableCell("5"));
        board.setCell(3, 0, new EditableCell("6"));

        board.setCell(1, 1, new NonEditableCell(""));
        board.setCell(1, 2, new NonEditableCell(""));
        board.setCell(1, 3, new NonEditableCell(""));
        board.setCell(2, 1, new NonEditableCell(""));
        board.setCell(2, 2, new NonEditableCell(""));
        board.setCell(2, 3, new NonEditableCell(""));
        board.setCell(3, 1, new NonEditableCell(""));
        board.setCell(3, 2, new NonEditableCell(""));
        board.setCell(3, 3, new NonEditableCell(""));
        return board;
    }

    private AbstractCell getCell(Board board, int column, int row) {
        Position position = new Position(row, column);
        return board.getCell(position);
    }

    private void setValue(Board board, int column, int row, String value) {
        Position position = new Position(row, column);
        board.setCellValue(position, value);
    }

    private boolean isBorken(Iterable<Rule> rules) {
        for (Rule rule : rules) {
            if (rule.isBroken()) {
                return true;
            }
        }
        return false;
    }
}
