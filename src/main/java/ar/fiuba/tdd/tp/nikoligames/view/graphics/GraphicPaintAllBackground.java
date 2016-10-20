package ar.fiuba.tdd.tp.nikoligames.view.graphics;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by tobias on 18/10/16.
 */
public class GraphicPaintAllBackground implements GraphicDraw {

    private Color backgroundColor;

    public GraphicPaintAllBackground(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void paint(Graphics graphic) {
        Graphics2D graphics2D = (Graphics2D) graphic;
        Rectangle2D bounds = graphic.getClipBounds();
        Integer positionX = (int) bounds.getX();
        Integer positionY = (int) bounds.getY();
        Integer width = (int) bounds.getWidth();
        Integer height = (int) bounds.getHeight();
        graphics2D.setColor(backgroundColor);
        graphics2D.fillRect(positionX,positionY,width,height);
    }
}
