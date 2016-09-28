package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
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

    public GridView createDefaultBoard(Integer rows, Integer cols) {
        GridView boardGridView = new GridOfSquares(rows, cols);
        boardGridView.setVisible(true);
        return boardGridView;
    }

    public void setCells(GridView board, AbstractSelectValueController controller){
        int rows = board.amountRows();
        int cols = board.amountCols();
        for (int  i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                CellView cell;
                if (j % 3 == 0) {
                    cell = new ClueCellView(j,controller);
                } else {
                    cell = new EditableNumberCell(controller);
                }
                cell.setCoordinates(i,j);
                board.addCellView(cell);
            }
        }
    }
}
