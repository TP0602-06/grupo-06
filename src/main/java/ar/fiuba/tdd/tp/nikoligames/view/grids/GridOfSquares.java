package ar.fiuba.tdd.tp.nikoligames.view.grids;

import java.awt.*;

import javax.swing.*;

/**
 * Es la vista de una grilla cuadrada.
 */
public class GridOfSquares extends GridView {
    private Integer rows;
    private Integer cols;

    public GridOfSquares(Integer rows, Integer cols) {
        setLayout(new GridLayout(rows, cols));
        setBackground(Color.white);
        this.rows = rows;
        this.cols = cols;
    }

    public void addCell(JButton cell) {
        add(cell);
    }

    private Integer calculateCellSide(Integer width, Integer height) {
        int minSide = Math.min(width, height);
        int divisor = rows;
        if (minSide != height) {
            divisor = cols;
        }
        return minSide / divisor;
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dimension;
        Container container = getParent();
        if (container != null) {
            dimension = container.getSize();
        } else {
            return new Dimension(10, 10);
        }
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();
        int cellSide = calculateCellSide(width, height);

        return new Dimension(cellSide * cols, cellSide * rows);
    }
}
