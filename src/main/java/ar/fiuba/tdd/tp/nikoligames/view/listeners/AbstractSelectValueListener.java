package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Esta clase se encarga del comportamiento de las celdas.
 */
public abstract class AbstractSelectValueListener implements MouseListener {

    protected final AbstractSelectValueController selectValueController;

    public AbstractSelectValueListener(AbstractSelectValueController selectValueController){
        this.selectValueController = selectValueController;
    }

    public void mouseClicked(MouseEvent event) {
        notofySelectValueController(event);
    }

    public void mouseEntered(MouseEvent event) {

    }

    public void mouseExited(MouseEvent event) {

    }

    public void mousePressed(MouseEvent event) {

    }

    public void mouseReleased(MouseEvent event) {
    }

    abstract void notofySelectValueController(MouseEvent event);
}
