package ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.focushelpers.focuscellviewhelper;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;

/**
 * Define el la forma de manejar el focus de la celda.
 */

public class FocusCellViewHelper implements AbstractFocusCellViewHelper {
    public void setFocus(CellView button) {
        button.setBackground(ColorSet.HOVER);
    }

    public void clearFocus(CellView button) {
        button.clearFocus();
    }
}
