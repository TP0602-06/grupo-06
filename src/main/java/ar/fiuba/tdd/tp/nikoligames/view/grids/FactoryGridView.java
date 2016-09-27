package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.FocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.ClueCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.ValueToSelectCellView;
import ar.fiuba.tdd.tp.nikoligames.view.parentView.View;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.SelectValueController;

import javax.swing.*;
import java.awt.*;
import java.security.acl.Group;

/**
 * Created by german on 9/25/2016.
 */
public class FactoryGridView implements AbstractFactoryBoard {

    public void createDefaultBoard(Integer rows, Integer cols, View view) {
        GridView boardGridView = new GridOfSquares(rows,cols);
        GridView selectValuesGridView = new GridOfSquares(1,9);

        AbstractSelectValueController selectValueController = new SelectValueController(boardGridView,selectValuesGridView);

        for (int j = 1; j <=9 ; j++) {
            Component component = new ValueToSelectCellView(j,selectValueController);
            selectValuesGridView.addCellView(component);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                Component component;
                if(j == 3){
                    component = new ClueCellView(8,selectValueController);

                }else {
                    component = new EditableNumberCell(selectValueController);
                }
                boardGridView.addCellView(component);
            }
        }

        boardGridView.setVisible(true);
        view.add(boardGridView);
        selectValuesGridView.setVisible(false);
        view.add(selectValuesGridView);
    }
}
