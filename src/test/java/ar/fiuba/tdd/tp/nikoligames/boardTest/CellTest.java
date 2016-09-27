package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.CellType;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.CellFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Pruebas del tipo cell
 */
public class CellTest {

    @Test
    public void creationTest() {
        Cell cell = new Cell();
        assertNotNull(cell);
    }

    @Test
    public void emptyCellTest() {
        Cell cell = new Cell();
        assertTrue(cell.isEmpty());
    }

    @Test
    public void notEmptyCellTest() {
        Cell cell = new Cell();
        cell.setValue("value");
        assertTrue(!cell.isEmpty());
    }

    @Test
    public void notNullCellTest() {
        Cell cell = new Cell();
        assertTrue(!cell.isNullCell());
    }

    @Test
    public void editableCellTest() {
        Cell cell = new Cell();
        assertTrue(cell.isEditable());
    }

    @Test
    public void equalCellTest() {
        Cell cell = new Cell();
        assertTrue(cell.equals(cell));
    }

    @Test
    public void notEqualCellTest() {
        Cell cell1 = (new Cell());
        cell1.setValue("value1");
        Cell cell2 = (new Cell());
        cell2.setValue("value2");
        assertTrue(cell1.equals(cell2));
    }



}
