package ar.fiuba.tdd.tp.nikoligames.view.clickables;

import ar.fiuba.tdd.tp.nikoligames.view.graphics.GraphicDraw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobias on 17/10/16.
 */
public abstract class PaintableClickable extends JButton {
    private List<GraphicDraw> graphics;

    public PaintableClickable() {
        this.graphics = new ArrayList<>();
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
