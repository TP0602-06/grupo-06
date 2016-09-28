package ar.fiuba.tdd.tp.nikoligames.games.kakuro;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
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
        for (int column = 0; column < this.board.getWidth(); column++) {
            for (int row = 0; row < this.board.getLength(); row++) {
                AbstractCell cell = this.getCell(column, row);
                String value = cell.getValue();
                if (this.isClue(value)) {
                    String columnClue = this.getColumnClue(value);
                    String rowClue = this.getRowClue(value);
                    if (this.hasClue(columnClue)) {
                        int lastEditableRow = this.getLastEditableRowForColumnClue(column, row + 1);
                        rules.addAll(this.getRowClueRules(Integer.parseInt(columnClue), column, row + 1, lastEditableRow));
                    }
                    if (this.hasClue(rowClue)) {
                        int lastEditableColumn = this.getLastEditableColumnForRowClue(column + 1, row);
                        rules.addAll(this.getColumnClueRules(Integer.parseInt(rowClue), column + 1, lastEditableColumn, row));
                    }
                }
            }
        }
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

    private int getLastEditableRowForColumnClue(int column, int firstRow) {
        for (int row = firstRow; row < this.board.getLength(); row++) {
            Position position = new Position(column, row);
            AbstractCell cell = this.board.getCell(position);
            if (!cell.isEditable()) {
                return row - 1;
            }
        }
        return this.board.getLength() - 1;
    }

    private int getLastEditableColumnForRowClue(int firstColumn, int row) {
        for (int column = firstColumn; column < this.board.getWidth(); column++) {
            AbstractCell cell = this.getCell(column, row);
            if (!cell.isEditable()) {
                return column - 1;
            }
        }
        return this.board.getWidth() - 1;
    }

    private AbstractCell getCell(int column, int row) {
        Position position = new Position(column, row);
        return this.board.getCell(position);
    }

    private boolean isClue(String value) {
        return value.contains("\\");
    }

    private String getColumnClue(String value) {
        return value.split("\\\\")[0];
    }

    private String getRowClue(String value) {
        return value.split("\\\\")[1];
    }

    private boolean hasClue(String value) {
        return (value != "*");
    }
}
