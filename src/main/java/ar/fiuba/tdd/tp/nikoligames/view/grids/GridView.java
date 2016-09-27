package ar.fiuba.tdd.tp.nikoligames.view.grids;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Interfaz para armar la vista de grillas.
 */
public abstract class GridView extends JPanel{
    public abstract void addCellView(Component cell);
    public abstract List<Component> getCellViews();
}