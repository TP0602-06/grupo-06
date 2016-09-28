package ar.fiuba.tdd.tp.nikoligames.view.grids.boardGridView;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

/**
 * Created by german on 9/25/2016.
 */
public interface AbstractFactoryBoard {
    GridView createBoardView(Integer rows, Integer cols, DrawableBoard modelBoard);
}
