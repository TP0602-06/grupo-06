package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;

/**
 * Created by german on 9/30/2016.
 */
public interface Board {
    int getRows();
    int getCols();
    void setCell(int row, int column, Cell cell);
    boolean setCellValue(Position position, String value);
    Cell getCell(Position position);
}
