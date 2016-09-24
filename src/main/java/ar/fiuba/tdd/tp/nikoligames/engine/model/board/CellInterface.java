package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Created by fedebrasburg on 9/23/16.
 */
public interface CellInterface {
    //TODO: fuerza solo enteros
    int getValue();

    void setValue(int value);

    boolean isEqual(Cell otherCell);
}
