package ar.fiuba.tdd.tp.nikoligames.view.grids.boardGridView;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

/**
 * Created by german on 9/28/2016.
 */
public class FactoryBoardViewFromModel implements AbstractFactoryBoard {
    AbstractSelectValueController selectValueController;

    @Override
    public GridView createBoardView(Integer rows, Integer cols, DrawableBoard modelBoard) {
        GridView boardGridView = new GridOfSquares(rows, cols);

        selectValueController.addBoardView(boardGridView);

        boardGridView.setVisible(true);

        return boardGridView;
    }

    public void fillGridWithCellsFromModel(GridView grid, DrawableBoard modelBoard){

    }
}
