package ar.fiuba.tdd.tp.nikoligames.boardTest;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.AdditionRule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Andres on 27/09/2016.
 */
public class RulesTest {
    private ArrayList<AbstractCell> createAddCells() {
        ArrayList<AbstractCell> cellList = new ArrayList<AbstractCell>();
        Cell cell = new Cell();
        cell.setValue("2");
        Cell cell2 = new Cell();
        cell2.setValue("3");
        cellList.add(cell);
        cellList.add(cell2);
        return cellList;
    }


    @Test
    public void testAddition() {
        ArrayList<AbstractCell> cellList = this.createAddCells();

        Cell cell = new Cell();
        cell.setValue("2");
        cellList.add(cell);
        AdditionRule addRule = new AdditionRule(8, cellList);
        assertTrue(addRule.isBroken());
        cell.setValue("3");
        assertFalse(addRule.isBroken());

    }
    @Test
    public void testAdditionWithEmptyCell() {
        ArrayList<AbstractCell> cellList = this.createAddCells();

        Cell cell = new Cell();
        cellList.add(cell);
        AdditionRule addRule = new AdditionRule(5, cellList);
        assertTrue(addRule.isBroken());
    }
    @Test
    public void testAdditionWithEmptyListOfCell() {
        ArrayList<AbstractCell> cellList = new ArrayList<AbstractCell>();
        AdditionRule addRule = new AdditionRule(5, cellList);
        assertTrue(addRule.isBroken());
    }
}
