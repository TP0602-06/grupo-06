package ar.fiuba.tdd.tp.nikoligames.view.graphics;

import java.awt.*;

/**
 * Created by tobias on 19/10/16.
 */
public class CircleGraphicDraw implements GraphicDraw {
    private Integer radius;
    private LinePosition center;
    private Color circleColor;

    public CircleGraphicDraw(Integer radius, LinePosition center, Color circleColor) {
        this.radius = radius;
        this.center = center;
        this.circleColor = circleColor;
    }

    public void paint(Graphics graphic) {
        Rectangle bounds = graphic.getClipBounds();

        double initialX = center.getWidth(bounds.getWidth());
        double initialY = center.getHeight(bounds.getHeight());
        Integer coordinateX = center(initialX);
        Integer coordinateY = center(initialY);

        graphic.setColor(circleColor);
        graphic.fillOval(coordinateX, coordinateY, radius, radius);
    }

    private Integer center(double coordinate) {
        return (int) Math.floor(coordinate - (double) radius / 2);
    }
}
