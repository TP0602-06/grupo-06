package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.event.MouseEvent;
import javax.swing.*;


/**
 * Esta clase se encarga del comportamiento de las celdas.
 */
public class SelectComponentCellListener extends AbstractSelectValueListener {

    public SelectComponentCellListener(AbstractSelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notifySelectValueController(MouseEvent event) {
        JButton cellView = (JButton) event.getSource();
        super.selectValueController.notifySelectedComponent(cellView);
    }
}
