package ar.fiuba.tdd.tp.nikoligames.boardTest;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.*;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.CellFactory;
import javafx.geometry.Pos;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class BoardTest {

    private int columns = 5, rows = 10;
    private int maxColumns = columns -1, maxRow = rows -1;

    @Test
    public void creationTest() {
        Board board = new Board(columns, rows);
        assertNotNull(board);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void outOfRangeWidthTest() {
        Board board = new Board(columns, rows);
        board.setCell(maxColumns +1, maxRow,new EditableCell());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void outOfRangeLengthTest() {
        Board board = new Board(columns, rows);
        board.setCell(maxColumns, maxRow +1,new EditableCell());
    }

    @Test
    public void insertCellTest() {
        String value = "value1";
        Board board = new Board(columns, rows);
        AbstractCell cell = (new CellFactory()).createCell(value);
        board.setCell(maxColumns, maxRow,cell);
        assertTrue(cell.equals(board.getCell(new Position(maxColumns, maxRow))));
    }

    @Test
    public void getDrawableCellListTest() {
        String value = "value1?";
        Position pos = new Position(maxColumns,maxRow);
        Board board = new Board(columns, rows);
        AbstractCell cell = (new CellFactory()).createCell(value);
        board.setCell(pos.getX(), pos.getY(),cell);
        ArrayList<Position> list = new ArrayList<>();
        list.add(pos);
        for(DrawableCell dcell : board.getArrayOfDrawableCells(list)){
            assertTrue(cell.equals(dcell));
            assertTrue(dcell.isEditable());
        }
    }

    @Test
    public void getCellListTest() {
        String value = "value1";
        Position pos = new Position(maxColumns,maxRow);
        Board board = new Board(columns, rows);
        AbstractCell cell = (new CellFactory()).createCell(value);
        board.setCell(pos.getX(), pos.getY(),cell);
        ArrayList<Position> list = new ArrayList<>();
        list.add(pos);
        for(DrawableCell bcell : board.getArrayOfCells(list)){
            assertTrue(cell.equals(bcell));
            assertTrue(!bcell.isEditable());
        }
    }


}
