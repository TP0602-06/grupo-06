package ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;

public class FocusCellViewHelper implements AbstractFocusCellViewHelper {
    public void setFocus(CellView button) {
        button.setBackground(ColorSet.HOVER);
    }

    public void clearFocus(CellView button) {
        button.clearFocus();
    }
}