package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.FocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.ClueCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.EditableNumberCell;

import java.awt.*;

/**
 * Created by german on 9/25/2016.
 */
public class FactoryGridView implements AbstractFactoryGridView {

    @Override
    public GridView createDefaultGridOfSquares(Integer rows, Integer cols) {
        GridView gridView = new GridOfSquares(rows,cols);
        AbstractFocusGridViewHelper focusGridViewHelper = new FocusGridViewHelper(gridView);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                Component component = new EditableNumberCell(focusGridViewHelper);
                gridView.addCellView(component);
            }
        }
        return gridView;
    }
}
