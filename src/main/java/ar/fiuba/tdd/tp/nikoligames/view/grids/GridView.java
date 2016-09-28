package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;

import java.awt.*;

import java.util.List;

import javax.swing.*;

/**
 * Interfaz para armar la vista de grillas.
 */
public abstract class GridView extends JPanel {

    public abstract void addCellView(CellView cell);

    public abstract List<CellView> getCellViews();

    public abstract Integer getCols();

    public abstract Integer getRows();
}