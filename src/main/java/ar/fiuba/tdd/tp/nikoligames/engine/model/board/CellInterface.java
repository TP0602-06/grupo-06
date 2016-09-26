package ar.fiuba.tdd.tp.nikoligames.engine.model.board;


/**
 * Created by fedebrasburg on 9/23/16.
 */
public interface CellInterface extends DrawableCell {
    //TODO: fuerza solo enteros
    String getValue();

    void setValue(String value);

    boolean isEqual(Cell otherCell);
}
