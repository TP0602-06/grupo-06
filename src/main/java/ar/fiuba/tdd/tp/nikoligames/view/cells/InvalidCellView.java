package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;

import java.awt.Color;

/**
 * Esta clase representa las celdas invalidas.
 */
public class InvalidCellView extends CellView {
    private Color backgroundColor = ColorSet.INVALID_BACKGROUND;

    public InvalidCellView() {
        this.setBackground(backgroundColor);
        this.setEnabled(false);
    }

    @Override
    public void clearFocus() {
        this.setBackground(backgroundColor);
    }
}
