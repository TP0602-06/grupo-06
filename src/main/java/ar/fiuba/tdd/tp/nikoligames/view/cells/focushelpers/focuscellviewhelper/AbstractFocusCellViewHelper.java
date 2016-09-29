package ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper;

import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;

/**
 * Esta interfaz define el uso del helper para manejar el focus de la celda.
 */

public interface AbstractFocusCellViewHelper {
    void setFocus(CellView button);

    void clearFocus(CellView button);
}
