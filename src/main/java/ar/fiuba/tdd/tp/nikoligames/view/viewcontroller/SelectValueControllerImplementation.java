package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper.AbstractFocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focuscellviewhelper.FocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focusgridviewhelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focushelpers.focusgridviewhelper.FocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Responsabilidades:
 * 1. Implementa la clase SelectValueController
 * Patrón: OBSERVER
 */
public class SelectValueControllerImplementation implements SelectValueController {

    private AbstractFocusGridViewHelper focusGridHelper;
    private GridView selectValueGridView;
    private Game game;
    private AbstractFocusCellViewHelper focusCellViewHelper = new FocusCellViewHelper();
    private AbstractEditableNumberCell lastSelectedEditableCellView;

    public SelectValueControllerImplementation(Game game) {
        this.game = game;
    }

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

    public void notifySelectedValue(String value) throws Exception {
        this.lastSelectedEditableCellView.changeValue(value);
        changeModelCellValue(value);
    }

    public void notifyClearValue() throws Exception {
        lastSelectedEditableCellView.clearValue();
        changeModelCellValue("");
    }

    private void changeModelCellValue(String value) throws Exception {
        ClassicPosition celPosition = new ClassicPosition(lastSelectedEditableCellView.getXIndex() + 1, lastSelectedEditableCellView.getYIndex() + 1);
        game.playMove(celPosition, value);
    }
}
