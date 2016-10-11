package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.graphics.GraphicDraw;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JButton;


/**
 * Esta clase es la claseBase de toda celda.
 */
public abstract class CellView extends JButton {
    private List<GraphicDraw> graphics;
    private Integer indexX;
    private Integer indexY;
    private Color backgroundColor;


    public CellView() {
        this.graphics = new ArrayList<>();
    }

    public void setCoordinates(Integer indexX, Integer indexY) {
        this.indexX = indexX;
        this.indexY = indexY;
    }

    public void setBaseBackground(Color color) {
        setBackground(color);
        backgroundColor = color;
    }

    public Integer getXIndex() {
        return this.indexX;
    }

    public Integer getYIndex() {
        return this.indexY;
    }

    public void clearFocus() {
        this.setBackground(backgroundColor);
    }

    public void addGraphic(GraphicDraw graphicDrawer) {
        graphics.add(graphicDrawer);
    }

    public void resetGraphics() {
        graphics.clear();
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        graphics.forEach((painter) -> painter.paint(graphic));
    }
}
