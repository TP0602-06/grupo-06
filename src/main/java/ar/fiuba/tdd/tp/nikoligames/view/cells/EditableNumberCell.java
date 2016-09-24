package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.listeners.SelectListener;

/**
 * Clase que define las celdas con posicion, son celdas con numeros, por eso heredan.
 */
public class EditableNumberCell extends NumberCellView {

    public EditableNumberCell() {
        super();
        this.addMouseListener(new SelectListener());
    }

    public void clearValue() {
        this.setText("");
    }
}
