package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Celda. Contiene informacion de celdas relevante para la logica del juego.
 */
public class Cell implements CellInterface {
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isEqual(Cell otherCell) {
        return (this.getValue() == otherCell.getValue());
    }

}
