package ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focusgridviewhelper;

import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper.AbstractFocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper.FocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 9/27/2016.
 */
public class FocusGridViewHelper implements AbstractFocusGridViewHelper {

    private GridView gridView;
    private AbstractFocusCellViewHelper focusHelper = new FocusCellViewHelper();

    public FocusGridViewHelper(GridView gridView) {
        this.gridView = gridView;
    }

    @Override
    public void clearFocus() {
        List<Component> cellViews = gridView.getCellViews();
        Iterator<Component> iteratorCellViews = cellViews.iterator();
        while (iteratorCellViews.hasNext()) {
            Component cellView = iteratorCellViews.next();
            focusHelper.clearFocus(cellView);
        }
    }
}
