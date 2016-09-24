package ar.fiuba.tdd.tp.nikoligames.view.grids;

import javax.swing.*;

/**
 * Interfaz para armar la vista de grillas.
 */
public abstract class GridView extends JPanel {
    public abstract void addCell(JButton cell, Integer xindex, Integer yindex);

}