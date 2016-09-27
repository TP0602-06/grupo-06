package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.AbstractEditableNumberCell;

import java.awt.*;

/**
 * Esta clase es la que sabe que hacer al escuchar las interacciones con las celdas.
 */
public interface AbstractSelectValueController {
    void notifySelectedEditableCellView(AbstractEditableNumberCell cellView);

    void notifySelectedComponent(Component component);

    void notifySelectedValue(Integer value);

    void notifyClearValue();
}
