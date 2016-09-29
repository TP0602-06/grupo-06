package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Esta clase es la que sabe que hacer al escuchar las interacciones con las celdas para su input.
 */
public interface AbstractSelectValueController {

    void addBoardView(GridView boardView);

    void addInputBoardView(GridView inputBoardView);

    void notifySelectedEditableCellView(AbstractEditableNumberCell cellView);

    void notifySelectedComponent(Component component);

    void notifySelectedValue(String value);

    void notifyClearValue();
}
