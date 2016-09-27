package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Esta clase se encarga del comportamiento de las celdas.
 */
public class SelectComponentCellListener extends AbstractSelectValueListener {

    protected JButton getButton(MouseEvent event) {
        return (JButton) event.getSource();
    }
    public SelectComponentCellListener(AbstractSelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notofySelectValueController(MouseEvent event) {
        JButton cellView = this.getButton(event);
        super.selectValueController.notifySelectedComponent(cellView);
    }
}
