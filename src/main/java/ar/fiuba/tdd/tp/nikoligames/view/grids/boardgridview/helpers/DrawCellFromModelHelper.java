package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell.EditableViewCell;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell.NotEditableViewCell;
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
        boolean isEditable = modelCell.isEditable();

        if (isEditable) {
            cellView = new EditableViewCell(controller);
        } else {
            cellView = new NotEditableViewCell(modelCell.getValue(), controller);
        }

        return cellView;
    }
}
