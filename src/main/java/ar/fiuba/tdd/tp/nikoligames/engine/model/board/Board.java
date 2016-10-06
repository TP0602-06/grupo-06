package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

/**
 * Created by german on 9/30/2016.
 */
public interface Board extends DrawableBoard {
    int getRows();

    int getCols();

    void setCell(Position coordinates, ConcreteNode cell);

    boolean changeCellValue(Position coordinates, String value);

    ConcreteNode getCell(Position coordinates);
}
