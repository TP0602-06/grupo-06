package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.InvalidCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ClueCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

/**
 * Esta clase define como elegir las celdas de la vista en base a las del modelo.
 */
public class DrawCellFromModelHelper implements AbstractDrawCellFromModelHelper {

    private final SelectValueController controller;

    public DrawCellFromModelHelper(SelectValueController controller) {
        this.controller = controller;
    }

    @Override
    public CellView drawCellFromModel(DrawableNode modelCell) {

        CellView cellView;

        if (modelCell.isEmpty() && modelCell.isReadOnly()) {
            cellView = new InvalidCellView();
        } else if (isCellEmptyAndEditable(modelCell)) {
            cellView = new EditableNumberCell(controller);
        } else if (isCellNonEditableAndNotEmpty(modelCell)) {
            cellView = new ClueCellView(modelCell.getValue(), controller);
        } else {
            cellView = new InvalidCellView();
        }

        return cellView;
    }

    private boolean isCellNonEditableAndNotEmpty(DrawableNode modelCell) {
        return !modelCell.isEmpty() && !modelCell.isEditable();
    }

    private boolean isCellEmptyAndEditable(DrawableNode modelCell) {
        return modelCell.isEmpty() && modelCell.isEditable();
    }

    private CellView createCell(DrawableNode modelCell) {
        return null;
    }
}
