package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsabilidades:
 * 1. Implementar una vista de grilla cuadriculada
 */
public class GridOfSquares extends GridView {
    List<CellView> cellViewList = new ArrayList<CellView>();
    private Integer rows;
    private Integer cols;

    public GridOfSquares(Integer rows, Integer cols) {
        setLayout(new GridLayout(rows, cols));
        setBackground(Color.white);
        this.rows = rows;
        this.cols = cols;
    }

    public void addCellView(CellView cell) {
        add(cell);
        cellViewList.add(cell);
    }

    public Integer getCols() {
        return cols;
    }

    public Integer getRows() {
        return rows;
    }

    @Override
    public List<CellView> getCellViews() {
        return cellViewList;
    }

    private Integer calculateCellSide(Integer width, Integer height) {
        int padding = 10;
        int widthWithPadding = width - padding;
        int heightWithPadding = height - padding;
        return Math.min(widthWithPadding / cols, heightWithPadding / rows);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dimension;
        int minimumDimension = 10;
        Container container = getParent();
        if (container != null) {
            dimension = container.getSize();
        } else {
            return new Dimension(minimumDimension, minimumDimension);
        }
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();
        int cellSide = calculateCellSide(width, height);

        return new Dimension(cellSide * cols, cellSide * rows);
    }
}
