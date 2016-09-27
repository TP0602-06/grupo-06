package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;

import javax.swing.*;

/**
 * Esta clase representa las celdas invalidas.
 */
public class InvalidCellView extends JButton {

    public InvalidCellView() {
        this.setBackground(ColorSet.INVALID_BACKGROUND);
        this.setEnabled(false);
    }

}
