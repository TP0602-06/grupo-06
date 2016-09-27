package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper.AbstractFocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper.FocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focusgridviewhelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focusgridviewhelper.FocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Esta clase escucha las interacciones con las celdas.
 */
public class SelectValueController implements AbstractSelectValueController {

    private final AbstractFocusGridViewHelper focusGridHelper;
    private final GridView selectValueGridView;
    private AbstractFocusCellViewHelper focusCellViewHelper = new FocusCellViewHelper();

    private AbstractEditableNumberCell lastSelectedEditableCellView;

    public SelectValueController(GridView boardView, GridView selectValueGridView) {
        this.focusGridHelper = new FocusGridViewHelper(boardView);
        this.selectValueGridView = selectValueGridView;
    }

    public void notifySelectedEditableCellView(AbstractEditableNumberCell cellView) {
        this.lastSelectedEditableCellView = cellView;
        focusGridHelper.clearFocus();
        focusCellViewHelper.setFocus(cellView);
        selectValueGridView.setVisible(true);
    }

    public void notifySelectedComponent(Component component) {
        selectValueGridView.setVisible(false);
        focusGridHelper.clearFocus();
    }

    public void notifySelectedValue(Integer value) {
        this.lastSelectedEditableCellView.changeValue(value);
    }

    public void notifyClearValue() {
        lastSelectedEditableCellView.clearValue();
    }
}
