package ar.fiuba.tdd.tp.nikoligames.view.grids.boardGridView.drawCellFromModelHelper;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.clueParser.ClueJsonParser;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.InvalidCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.KakuroCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ClueCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.util.IntSummaryStatistics;

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
            ClueJsonParser clueParser = new ClueJsonParser();
            if (clueParser.isBarClue(modelCell)){
                KakuroCellView kakuroview = new KakuroCellView();
                if (clueParser.hasTopClue(modelCell)) {
                    String value = clueParser.topClue(modelCell);
                    kakuroview.setTop(Integer.parseInt(value));
                }
                if (clueParser.hasBottomClue(modelCell)){
                    String value = clueParser.bottomClue(modelCell);
                    kakuroview.setBottom(Integer.parseInt(value));
                }
                cellView = kakuroview;
            }else{
                cellView = new ClueCellView(Integer.parseInt(modelCell.getValue()),controller);
            }

        }else{
            cellView = new InvalidCellView();
        }

        return cellView;
    }
}
