package ar.fiuba.tdd.tp.nikoligames.engine.model.board;


/**
 * Celda. Contiene informacion de celdas relevante para la logica del juego.
 */
public class EditableCell extends AbstractCell {

    public EditableCell(String value) {
        super(value);
    }

    public boolean isNullCell() {
        return false;
    }

    public boolean isEditable() {
        return true;
    }
}
