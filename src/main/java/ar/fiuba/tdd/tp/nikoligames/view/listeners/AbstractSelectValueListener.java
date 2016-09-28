package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Esta clase se encarga del comportamiento de las celdas.
 */
public abstract class AbstractSelectValueListener extends MouseAdapter {

    protected final AbstractSelectValueController selectValueController;

    public AbstractSelectValueListener(AbstractSelectValueController selectValueController) {
        this.selectValueController = selectValueController;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        notifySelectValueController(event);
    }

    abstract void notifySelectValueController(MouseEvent event);
}
