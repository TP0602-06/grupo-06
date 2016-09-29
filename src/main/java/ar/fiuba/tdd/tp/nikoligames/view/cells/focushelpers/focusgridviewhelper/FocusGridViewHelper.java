package ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focusgridviewhelper;

import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper.AbstractFocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper.FocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

/**
 * Define como limpia la seleccion del tablero de la vista.
 */
public class FocusGridViewHelper implements AbstractFocusGridViewHelper {

    private GridView gridView;
    private AbstractFocusCellViewHelper focusHelper = new FocusCellViewHelper();

    public FocusGridViewHelper(GridView gridView) {
        this.gridView = gridView;
    }

    @Override
    public void clearFocus() {
        List<CellView> cellViews = gridView.getCellViews();
        Iterator<CellView> iteratorCellViews = cellViews.iterator();
        while (iteratorCellViews.hasNext()) {
            CellView cellView = iteratorCellViews.next();
            focusHelper.clearFocus(cellView);
        }
    }
}
