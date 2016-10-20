package ar.fiuba.tdd.tp.nikoligames.view.board.positionsolver;

import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Created by tobias on 19/10/16.
 */
public class CellSizeCalculator {
    private GridView grid;

    public CellSizeCalculator(GridView grid) {
        this.grid = grid;
    }

    public Integer getWidth() {
        return divide(grid.getWidth(), grid.getCols());
    }

    public Integer getHeight() {
        return divide(grid.getHeight(), grid.getCols());
    }

    private Integer divide(Integer borderSize, Integer celQuantity) {
        return (int) Math.floor((double) borderSize / celQuantity);
    }
}
