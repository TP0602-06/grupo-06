package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import java.util.ArrayList;

/**
 * Created by Andres on 26/09/2016.
 */
public interface DrawableBoard {
    public ArrayList<? extends DrawableCell> getArrayOfDrawableCells(ArrayList<Position> positions);

    public void setCellValue(Position position, String value);
}