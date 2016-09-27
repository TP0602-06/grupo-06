package ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell;

import javax.swing.*;

/**
 * Created by german on 9/27/2016.
 */
public abstract class AbstractEditableNumberCell extends JButton {
    public abstract void changeValue(Integer value);
    public abstract void clearValue();
}
