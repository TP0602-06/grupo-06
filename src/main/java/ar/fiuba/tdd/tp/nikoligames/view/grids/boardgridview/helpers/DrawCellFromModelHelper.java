package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.clueparser.ClueJsonParser;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.InvalidCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.KakuroCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ClueCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

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
        ClueJsonParser clueParser = new ClueJsonParser();
        if (clueParser.isBarClue(modelCell)) {
            KakuroCellView kakuroview = new KakuroCellView();
            if (clueParser.hasTopClue(modelCell)) {
                String value = clueParser.topClue(modelCell);
                kakuroview.setTop(value);
            }
            if (clueParser.hasBottomClue(modelCell)) {
                String value = clueParser.bottomClue(modelCell);
                kakuroview.setBottom(value);
            }
            return kakuroview;
        }
        return new ClueCellView(Integer.parseInt(modelCell.getValue()), controller);
    }
}
