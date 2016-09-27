package ar.fiuba.tdd.tp.nikoligames.view.grids;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

/**
 * Es la vista de una grilla cuadrada.
 */
public class GridOfSquares extends GridView {
    private Integer rows;
    private Integer cols;
    List<Component> cellViewList = new ArrayList<>();


    public GridOfSquares(Integer rows, Integer cols) {
        setLayout(new GridLayout(rows, cols));
        setBackground(Color.white);
        this.rows = rows;
        this.cols = cols;
    }

    public void addCellView(Component cell) {
        add(cell);
        cellViewList.add(cell);
    }

    @Override
    public List<Component> getCellViews() {
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
