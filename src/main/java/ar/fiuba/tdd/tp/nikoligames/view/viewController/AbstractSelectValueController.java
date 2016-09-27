package ar.fiuba.tdd.tp.nikoligames.view.viewController;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.AbstractEditableNumberCell;

import java.awt.*;

/**
 * Created by german on 9/27/2016.
 */
public interface AbstractSelectValueController {
    void notifySelectedEditableCellView(AbstractEditableNumberCell cellView);
    void notifySelectedComponent(Component component);
    void notifySelectedValue(Integer value);
}
