package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.EditableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.NonEditableCell;

/**
 * Fabrica de cledas que permite al cliente no conocer la implementacion de la creacion de una celda y asi no depender de ella.
 */
public class CellFactory {

    private static CellFactory instance;

    private CellFactory() {

    }

    public AbstractCell createCell(String value) {
        if (value.contains("?")) {
            return new EditableCell(value);
        } else {
            return new NonEditableCell(value);
        }
    }

    public static CellFactory getInstance() {
        if (instance == null) {
            instance = new CellFactory();
        }
        return instance;
    }
}
