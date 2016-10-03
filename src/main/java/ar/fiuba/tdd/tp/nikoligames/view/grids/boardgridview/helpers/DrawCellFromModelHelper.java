package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.NotEditableViewCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.EditableViewCell;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import javax.swing.*;

/**
 * Esta clase define como elegir las celdas de la vista en base a las del modelo.
 */
public class DrawCellFromModelHelper implements AbstractDrawCellFromModelHelper {
    private  int random = 0;
    private final SelectValueController controller;

    public DrawCellFromModelHelper(SelectValueController controller) {
        this.controller = controller;
    }

    @Override
    public CellView drawCellFromModel(DrawableCell modelCell) {

        CellView cellView;
        boolean isEditable = modelCell.isEditable();

        if (isEditable) {
            cellView = new EditableViewCell(controller);
        } else {
            cellView = new NotEditableViewCell(modelCell.getValue(),controller);
        }

        return cellView;
    }
}
