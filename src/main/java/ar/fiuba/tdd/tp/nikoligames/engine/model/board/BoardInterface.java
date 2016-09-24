package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Created by fedebrasburg on 9/23/16.
 */
public interface BoardInterface {

    void setCell(int column, int row, CellInterface cell);

    public CellInterface getCell(Position position);

    int getLength();

    int getWidth();

}
