package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;

import javax.swing.*;

/**
 * Estas celdas son la vista de celdas que contienen numeros.
 */
public class NumberCellView extends JButton {

    public NumberCellView() {
        super();
        setBackground(ColorSet.NORMAL_BACKGROUND);
        setForeground(ColorSet.NUMBER);
    }

    public void setNumber(Integer number) {
        this.setText(String.valueOf(number));
    }

}


