package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawableChangeNodeValuePlay;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawablePlay;
import ar.fiuba.tdd.tp.nikoligames.view.board.BoardView;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.focushelpers.focuscellviewhelper.AbstractFocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.focushelpers.focuscellviewhelper.FocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.focushelpers.focusgridviewhelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.focushelpers.focusgridviewhelper.FocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell.EditableViewCell;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Responsabilidades:
 * 1. Implementa la clase SelectValueController
 * Patrón: OBSERVER
 */
public class SelectValueControllerImp implements SelectValueController {

    private AbstractFocusGridViewHelper focusGridHelper;
    private GridView selectValueGridView;
    private Game game;
    private AbstractFocusCellViewHelper focusCellViewHelper = new FocusCellViewHelper();
    private AbstractEditableNumberCell lastSelectedEditableCellView;

    public SelectValueControllerImp(Game game) {
        this.game = game;
    }

    public void addGridView(GridView boardView) {
        this.focusGridHelper = new FocusGridViewHelper(boardView);
    }

    public void addInputBoardView(GridView inputBoardView) {
        this.selectValueGridView = inputBoardView;
    }

    public void notifySelectedEditableCellView(AbstractEditableNumberCell cellView) {
        this.lastSelectedEditableCellView = cellView;
        focusGridHelper.clearFocus();
        focusCellViewHelper.setFocus(cellView);
        showInputs();
    }

    public void notifySelectedComponent(Component component) {
        hideInputs();
        focusGridHelper.clearFocus();
    }

    public void notifySelectedValue(String value) throws Exception {
        this.lastSelectedEditableCellView.changeValue(value);
        changeModelCellValue(value);
    }

    public void notifyClearValue() throws Exception {
        lastSelectedEditableCellView.clearValue();
        changeModelCellValue("");
    }

    private void displayInputs(boolean show) {
        if (selectValueGridView != null) {
            selectValueGridView.setVisible(show);
        }
    }

    private void hideInputs() {
        displayInputs(false);
    }

    private void showInputs() {
        displayInputs(true);
    }

    private void changeModelCellValue(String value) throws Exception {
        int row = lastSelectedEditableCellView.getXIndex();
        int col = lastSelectedEditableCellView.getYIndex();
        ClassicPosition celPosition = new ClassicPosition(row, col);
        game.changeNodeValue(celPosition, value);
    }

}
