package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;

/**
 * Created by german on 9/30/2016.
 */
public interface Board extends DrawableBoard {
    int getRows();

    int getCols();

    void setCell(Position coordinates, Cell cell);

    boolean changeCellValue(Position coordinates, String value);

    Cell getCell(Position coordinates);
}
