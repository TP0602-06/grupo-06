package ar.fiuba.tdd.tp.nikoligames.rulestest;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.EditableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.AdditionRule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by fedebrasburg on 9/27/16.
 */
public class AdditionRuleTest {
    private ArrayList<AbstractCell> createAddCells() {
        ArrayList<AbstractCell> cellList = new ArrayList<AbstractCell>();
        EditableCell cell = new EditableCell();
        cell.setValue("2");
        EditableCell cell2 = new EditableCell();
        cell2.setValue("3");
        cellList.add(cell);
        cellList.add(cell2);
        return cellList;
    }


    @Test
    public void testAddition() {
        ArrayList<AbstractCell> cellList = this.createAddCells();

        EditableCell cell = new EditableCell();
        cell.setValue("2");
        cellList.add(cell);
        AdditionRule addRule = new AdditionRule(8, cellList);
        assertTrue(addRule.isBroken());
        cell.setValue("3");
        assertFalse(addRule.isBroken());

    }


    @Test
    public void testAdditionWithEmptyListOfCell() {
        ArrayList<AbstractCell> cellList = new ArrayList<AbstractCell>();
        AdditionRule addRule = new AdditionRule(5, cellList);
        assertTrue(addRule.isBroken());
    }

    @Test
    public void testAdditionWithEmptyCell() {
        ArrayList<AbstractCell> cellList = new ArrayList<AbstractCell>();
        EditableCell cell = new EditableCell();
        cellList.add(cell);
        AdditionRule addRule = new AdditionRule(5, cellList);
        assertTrue(addRule.isBroken());
    }
}
