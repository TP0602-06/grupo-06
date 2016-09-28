package ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;

import javax.swing.*;

/**
 * Created by german on 9/27/2016.
 */
public abstract class AbstractEditableNumberCell extends CellView {

    public abstract void changeValue(Integer value);

    public abstract void clearValue();
}
