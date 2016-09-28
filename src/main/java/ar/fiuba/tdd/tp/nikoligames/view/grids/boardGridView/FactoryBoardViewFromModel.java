package ar.fiuba.tdd.tp.nikoligames.view.grids.boardGridView;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardGridView.drawCellFromModelHelper.DrawCellFromModelHelper;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by german on 9/28/2016.
 */
public class FactoryBoardViewFromModel implements AbstractFactoryBoard {
    AbstractSelectValueController selectValueController;

    @Override
    public GridView createBoardView(Integer rows, Integer cols, DrawableBoard modelBoard) {
        GridView boardGridView = new GridOfSquares(modelBoard.getLength(), modelBoard.getWidth());

        selectValueController.addBoardView(boardGridView);

        boardGridView.setVisible(true);

        return boardGridView;
    }

    public void fillGridWithCellsFromModel(GridView grid, DrawableBoard modelBoard){
        DrawCellFromModelHelper helper = new DrawCellFromModelHelper(selectValueController);
        ArrayList<? extends DrawableCell> drawableCells = modelBoard.getAllDrawableCells();

        Iterator<? extends DrawableCell> iterator = drawableCells.iterator();
        while(iterator.hasNext()){
            DrawableCell modelCell = iterator.next();
            CellView cellView = helper.drawCellFromModel(modelCell);
            grid.addCellView(cellView);

        }

    }
}
