package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Celda no editable. Extiende a la celda general y provee al modelo una forma de representar celdas que no pueden ser editadas.
 */
public class NonEditableCell extends AbstractCell {

    public NonEditableCell(String value) {
        super(value);
    }

    public boolean isNullCell() {
        return false;
    }


    public boolean isEditable() {
        return false;
    }

}
