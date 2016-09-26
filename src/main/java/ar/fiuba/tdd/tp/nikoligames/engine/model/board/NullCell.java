package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Created by Andres on 24/09/2016.
 */
public class NullCell implements CellInterface {
    //TODO: fuerza solo enteros
    public String getValue() {
        return "";
    }

    ;

    public void setValue(String value) {
    }

    ;

    public boolean isEqual(Cell otherCell) {
        return false;
    }

    ;
    public boolean isNullCell(){
        return true;
    }

    public boolean isEmpty(){
        return true;
    }
}
