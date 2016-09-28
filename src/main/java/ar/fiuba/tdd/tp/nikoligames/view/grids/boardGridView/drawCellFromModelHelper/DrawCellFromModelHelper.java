package ar.fiuba.tdd.tp.nikoligames.view.grids.boardGridView.drawCellFromModelHelper;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.InvalidCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;
import javafx.scene.control.Cell;

public class DrawCellFromModelHelper implements AbstractDrawCellFromModelHelper {

    private final AbstractSelectValueController controller;

    public DrawCellFromModelHelper(AbstractSelectValueController controller){
        this.controller = controller;
    }
    @Override
    public CellView drawCellFromModel(DrawableCell modelCell) {

        CellView cellView;

        if (modelCell.isEmpty() && !modelCell.isEditable()){
            cellView = new InvalidCellView();
        }else if(modelCell.isEmpty() && modelCell.isEditable()){
            cellView = new  EditableNumberCell(controller);
        }else if(!modelCell.isEmpty() && !modelCell.isEditable()){
            System.out.println("regla o clue" + modelCell.getValue());
            cellView = new InvalidCellView();
        }else{
            cellView = new InvalidCellView();
        }

        return cellView;
    }
}
