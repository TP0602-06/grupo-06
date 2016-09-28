package tdd.engine.model;

/**
 * Created by fedebrasburg on 9/23/16.
 */
public interface EditableCell {
    //TODO: fuerza solo enteros
    int getNumber();
    boolean isEqual(EditableCell otherCell);
}
