package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.CellInterface;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.CellType;

/**
 * Created by Andres on 24/09/2016.
 */
public class CellFactory {
    private static CellFactory instance = null;

    private CellFactory() {
    }


    //Singleton
    public static CellFactory getInstance() {
        if (instance == null) {
            instance = new CellFactory();
        }
        return instance;
    }

    public CellInterface createCell(CellType cellType, String value) {
        CellInterface cell = cellType.createCell();
        cell.setValue(value);
        return cell;
    }
}
