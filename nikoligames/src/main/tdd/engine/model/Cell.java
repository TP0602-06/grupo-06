package tdd.engine.model;

/**
 * Created by fedebrasburg on 9/23/16.
 */
public interface Cell {
    //TODO: fuerza solo enteros
    int getNumber();
    boolean isEqual(Cell otherCell);
}
