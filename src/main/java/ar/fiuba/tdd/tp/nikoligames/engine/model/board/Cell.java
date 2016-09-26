package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import java.util.Objects;

/**
 * Celda. Contiene informacion de celdas relevante para la logica del juego.
 */
public class Cell implements CellInterface {
    private String value="";



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEqual(Cell otherCell) {
        return (Objects.equals(this.getValue(), otherCell.getValue()));
    }

    public boolean isNullCell(){
        return true;
    }

    public boolean isEmpty(){
        return true;
    }
}
