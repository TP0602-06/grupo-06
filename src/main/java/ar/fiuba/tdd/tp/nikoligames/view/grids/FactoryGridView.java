package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.cells.KakuroCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ClueCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.View;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.*;

/**
 * Created by german on 9/25/2016.
 */
public class FactoryGridView implements AbstractFactoryBoard {

    public void createDefaultBoard(Integer rows, Integer cols, View view) {
        GridView boardGridView = new GridOfSquares(rows, cols);
        InputGridFactory factoryInput = new InputDigitFactory();
        GridView selectValuesGridView = factoryInput.createInputGrid();

        AbstractSelectValueController selectValueController = new SelectValueController(boardGridView, selectValuesGridView);

        factoryInput.addInputCells(selectValuesGridView, selectValueController);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Component component;
                if (j == 3) {
                    component = new ClueCellView(8, selectValueController);

                } else {
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
