package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.Coordinates;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;

/**
 * Created by german on 9/30/2016.
 */
public interface Board {
    int getRows();
    int getCols();
    void setCell(Coordinates coordinates,  Cell cell);
    boolean setCellValue(Coordinates coordinates, String value);
    Cell getCell(Coordinates coordinates);
}
