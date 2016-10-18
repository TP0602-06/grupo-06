package ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;

/**
 * Esta interfaz define el comportamiento de las celdas de la vista.
 */
public abstract class AbstractEditableNumberCell extends CellView {

    public abstract void changeValue(String value);

    public abstract void clearValue();
}
