package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.InvalidCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

/**
 * Esta clase define como elegir las celdas de la vista en base a las del modelo.
 */
public class DrawCellFromModelHelper implements AbstractDrawCellFromModelHelper {

    private final AbstractSelectValueController controller;

    public DrawCellFromModelHelper(AbstractSelectValueController controller) {
        this.controller = controller;
    }

    @Override
    public CellView drawCellFromModel(DrawableCell modelCell) {

        CellView cellView;

        if (modelCell.isEmpty() && !modelCell.isEditable()) {
            cellView = new InvalidCellView();
        } else if (isCellEmptyAndEditable(modelCell)) {
            cellView = new EditableNumberCell(controller);
        } else if (isCellNonEditableAndNotEmpty(modelCell)) {
            cellView = createCell(modelCell);
        } else {
            cellView = new InvalidCellView();
        }

        return cellView;
    }

    private boolean isCellNonEditableAndNotEmpty(DrawableCell modelCell) {
        return !modelCell.isEmpty() && !modelCell.isEditable();
    }

    private boolean isCellEmptyAndEditable(DrawableCell modelCell) {
        return modelCell.isEmpty() && modelCell.isEditable();
    }

    private CellView createCell(DrawableCell modelCell) {

        return null;
    }
}
