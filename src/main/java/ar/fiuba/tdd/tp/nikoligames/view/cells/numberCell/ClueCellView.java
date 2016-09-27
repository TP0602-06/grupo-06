package ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;

import javax.swing.*;

/**
 * Estas celdas son la vista de celdas que contienen numeros.
 * Una vez creadas no puede cambiarse su valor
 */
public class ClueCellView extends JButton {

    public ClueCellView(Integer clue) {
        setBackground(ColorSet.NORMAL_BACKGROUND);
        setForeground(ColorSet.NUMBER);
        this.setText(Integer.toString(clue));
    }
}


