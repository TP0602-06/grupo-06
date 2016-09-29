package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper.AbstractFocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper.FocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focusgridviewhelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focusgridviewhelper.FocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Esta clase escucha las interacciones con las celdas.
 */
public class SelectValueController implements AbstractSelectValueController {

    private AbstractFocusGridViewHelper focusGridHelper;
    private GridView selectValueGridView;
    private Game game;

    public SelectValueController(Game game) {
        this.game = game;
    }

    private AbstractFocusCellViewHelper focusCellViewHelper = new FocusCellViewHelper();

    private AbstractEditableNumberCell lastSelectedEditableCellView;

    public void addBoardView(GridView boardView) {
        this.focusGridHelper = new FocusGridViewHelper(boardView);
    }

    public void addInputBoardView(GridView inputBoardView) {
        this.selectValueGridView = inputBoardView;
    }

    public void notifySelectedEditableCellView(AbstractEditableNumberCell cellView) {
        this.lastSelectedEditableCellView = cellView;
        focusGridHelper.clearFocus();
        focusCellViewHelper.setFocus(cellView);
        selectValueGridView.setVisible(true);
    }

    public void notifySelectedComponent(Component component) {
        selectValueGridView.setVisible(false);
        focusGridHelper.clearFocus();
    }

    public void notifySelectedValue(String value) {
        this.lastSelectedEditableCellView.changeValue(value);
        changeModelCellValue(value);
    }

    public void notifyClearValue() {
        lastSelectedEditableCellView.clearValue();
        changeModelCellValue("");
    }

    private void changeModelCellValue(String value) {
        Position celPosition = new Position(lastSelectedEditableCellView.getXIndex(), lastSelectedEditableCellView.getYIndex());
        game.insertValueInCell(celPosition, value);
    }
}
