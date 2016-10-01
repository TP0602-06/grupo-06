package ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener;

import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Responsabilidades:
 * 1. Capturar evento del click del mouse en cada celda y notificarlo al obervador - SelectValueController -
 * Justificación de herencia: El paquete Swing se suele trabajar de esta forma
 * Patrón:
 * 1. OBSERVER
 */
public abstract class AbstractSelectValueListener extends MouseAdapter {

    protected final SelectValueController selectValueController;

    public AbstractSelectValueListener(SelectValueController selectValueController) {
        this.selectValueController = selectValueController;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        try {
            notifySelectValueController(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    abstract void notifySelectValueController(MouseEvent event) throws Exception;
}
