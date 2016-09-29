package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.EditableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.NonEditableCell;

/**
 * Created by Andres on 24/09/2016.
 * Class
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
