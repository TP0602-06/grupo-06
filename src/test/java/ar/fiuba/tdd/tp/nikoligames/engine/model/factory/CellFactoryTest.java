package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.EditableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.NonEditableCell;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by mcapolupo on 28/9/16.
 */
public class CellFactoryTest {

    @Test
    public void testCreateEditableCell() {

        //Setup
        String input = "?";
        CellFactory cellFactory = CellFactory.getInstance();

        //Call Method
        AbstractCell cell = cellFactory.createCell(input);

        //Asserts
        assertTrue(cell instanceof EditableCell);
    }

    @Test
    public void testCreateNonEditableCell() {

        //Setup
        String input = "*\\*";
        CellFactory cellFactory = CellFactory.getInstance();

        //Call Method
        AbstractCell cell = cellFactory.createCell(input);

        //Asserts
        assertTrue(cell instanceof NonEditableCell);
    }

}
