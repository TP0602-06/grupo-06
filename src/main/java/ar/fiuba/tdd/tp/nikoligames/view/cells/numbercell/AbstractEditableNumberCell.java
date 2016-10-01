package ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;

/**
 * Esta interfaz define el comportamiento de las celdas de la vista.
 */
public abstract class AbstractEditableNumberCell extends CellView {

    public abstract void changeValue(String value);

    public abstract void clearValue();
}
