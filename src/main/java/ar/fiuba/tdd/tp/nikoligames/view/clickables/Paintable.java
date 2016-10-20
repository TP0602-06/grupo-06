package ar.fiuba.tdd.tp.nikoligames.view.clickables;

import ar.fiuba.tdd.tp.nikoligames.view.graphics.GraphicDraw;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


/**
 * Created by tobias on 17/10/16.
 */
public abstract class Paintable extends JButton {
    private List<GraphicDraw> graphics;
    private Color backgroundColor;

    public Paintable() {
        this.graphics = new ArrayList<>();
    }

    public void addGraphic(GraphicDraw graphicDrawer) {
        graphics.add(graphicDrawer);
    }

    public void resetGraphics() {
        graphics.clear();
    }

    public void setBaseBackground(Color color) {
        setBackground(color);
        backgroundColor = color;
    }

    public void clearFocus() {
        this.setBackground(backgroundColor);
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        graphics.forEach((painter) -> painter.paint(graphic));
    }
}
