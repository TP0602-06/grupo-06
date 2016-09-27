package ar.fiuba.tdd.tp.nikoligames.view.grids;

import java.awt.*;

import java.util.List;

import javax.swing.*;

/**
 * Interfaz para armar la vista de grillas.
 */
public abstract class GridView extends JPanel {

    public abstract void addCellView(Component cell);

    public abstract List<Component> getCellViews();
}