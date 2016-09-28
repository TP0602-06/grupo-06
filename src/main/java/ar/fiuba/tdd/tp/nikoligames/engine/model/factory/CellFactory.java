package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andres on 24/09/2016.
 * Class
 */
public class CellFactory {

    public CellFactory() {}

    public AbstractCell createCell(String value) {
        if (value.contains("?")) {
            return new EditableCell(value);
        } else {
            return new NonEditableCell(value);
        }
    }
}
