package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.FocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.ClueCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.ValueToSelectCellView;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.SelectValueController;

import javax.swing.*;
import java.awt.*;
import java.security.acl.Group;

/**
 * Created by german on 9/25/2016.
 */
public class FactoryGridView implements AbstractFactoryBoard {

    public JPanel createDefaultBoard(Integer rows, Integer cols, GridView selectValuesPanel) {
        GridView boardGridView = new GridOfSquares(rows,cols);
        AbstractSelectValueController selectValueController = new SelectValueController(boardGridView,selectValuesPanel);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                Component component = new EditableNumberCell(selectValueController);
                boardGridView.addCellView(component);
            }
        }
        JPanel boardPanel = new JPanel(new FlowLayout());
        boardPanel.add(boardGridView);
        boardPanel.add(selectValuesPanel);

        return boardPanel;
    }

    @Override
    public GridView createDefaultSelectValuesPanel() {
        GridView selectValuesGridView = new GridOfSquares(1,9);
        for (int j = 1; j <=9 ; j++) {
            Component component = new ValueToSelectCellView(j);
            selectValuesGridView.addCellView(component);
        }

        return selectValuesGridView;
    }


}
