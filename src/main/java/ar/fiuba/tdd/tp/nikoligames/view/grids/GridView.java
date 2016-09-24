package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.cells.NumberCellView;

import javax.swing.*;

/**
 * Interfaz para armar la vista de grillas
 */

public abstract class GridView extends JPanel{

    public abstract void addCell(JButton cell, Integer x, Integer y);

}