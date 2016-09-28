package ar.fiuba.tdd.tp.nikoligames.view.grids.boardGridView.drawCellFromModelHelper;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.InvalidCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

public class DrawCellFromModelHelper implements AbstractDrawCellFromModelHelper {

    private final AbstractSelectValueController controller;

    public DrawCellFromModelHelper(AbstractSelectValueController controller){
        this.controller = controller;
    }
    @Override
    public CellView drawCellFromModel(DrawableCell modelCell) {
        if (modelCell.isEmpty() && !modelCell.isEditable()){
            return new InvalidCellView();
        }
        if(modelCell.isEmpty() && modelCell.isEditable()){
            return new EditableNumberCell(controller);
        }
        if(!modelCell.isEmpty() && !modelCell.isEditable()){
            System.out.println(modelCell.getValue());
        }
        return new InvalidCellView();
    }
}
