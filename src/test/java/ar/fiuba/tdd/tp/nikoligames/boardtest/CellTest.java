package ar.fiuba.tdd.tp.nikoligames.boardtest;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Pruebas del tipo cell.
 */
public class CellTest {
    @Test
    public void creationTest() {
        EditableCell cell = new EditableCell();
        assertNotNull(cell);
    }

    @Test
    public void emptyCellTest() {
        EditableCell cell = new EditableCell();
        assertTrue(cell.isEmpty());
    }

    @Test
    public void notEmptyCellTest() {
        EditableCell cell = new EditableCell();
        cell.setValue("value");
        assertTrue(!cell.isEmpty());
    }


    @Test
    public void editableCellTest() {
        EditableCell cell = new EditableCell();
        assertTrue(cell.isEditable());
    }

    @Test
    public void equalCellTest() {
        EditableCell cell = new EditableCell();
        assertTrue(cell.equals(cell));
    }

    @Test
    public void notEqualCellTest() {
        EditableCell cell1 = (new EditableCell());
        cell1.setValue("value1");
        EditableCell cell2 = (new EditableCell());
        cell2.setValue("value2");
        assertTrue(!cell1.equals(cell2));
    }


}
