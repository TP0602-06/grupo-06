package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.cells.InvalidCellView;

/**
 * Created by german on 9/25/2016.
 */
public class FactoryGridView implements AbstractFactoryGridView {

    @Override
    public GridView createDefaultGridOfSquares(Integer rows, Integer cols) {
        GridView gridView = new GridOfSquares(rows,cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                gridView.addCell(new InvalidCellView());
            }
        }
        return gridView;
    }
}
