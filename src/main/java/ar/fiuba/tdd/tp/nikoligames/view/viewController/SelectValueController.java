package ar.fiuba.tdd.tp.nikoligames.view.viewController;

import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.FocusCellViewHelper.AbstractFocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.FocusCellViewHelper.FocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.FocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by german on 9/27/2016.
 */
public class SelectValueController implements AbstractSelectValueController {

    private final AbstractFocusGridViewHelper focusGridHelper;
    private final GridView selectValueGridView;
    private AbstractFocusCellViewHelper focusCellViewHelper = new FocusCellViewHelper();

    private AbstractEditableNumberCell lastSelectedEditableCellView;

    public SelectValueController(GridView boardView, GridView selectValueGridView){
        this.focusGridHelper = new FocusGridViewHelper(boardView);
        this.selectValueGridView = selectValueGridView;
    }

    public void notifySelectedEditableCellView(AbstractEditableNumberCell cellView){
        this.lastSelectedEditableCellView = cellView;
        focusGridHelper.clearFocus();
        focusCellViewHelper.setFocus(cellView);
        selectValueGridView.setVisible(true);
    }

    public void notifySelectedComponent(Component component){
        selectValueGridView.setVisible(false);
        focusGridHelper.clearFocus();
    }

    public void notifySelectedValue(Integer value){
        this.lastSelectedEditableCellView.changeValue(value);
    }
}
