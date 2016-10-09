package ar.fiuba.tdd.tp.nikoligames.view.graphics;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by tobias on 09/10/16.
 */
public class LineGraphicDraw implements GraphicDraw{

    private Color color;
    private LinePosition start;
    private LinePosition end;

    public LineGraphicDraw(Color color, LinePosition start, LinePosition end ) {
        this.color = color;
        this.start = start;
        this.end = end;
    }

    @Override
    public void paint(Graphics graphic) {
        Graphics2D g2 = (Graphics2D) graphic;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(2f));
        Rectangle2D bounds = graphic.getClipBounds();
        g2.draw(createLine(bounds));
    }

    private Line2D createLine(Rectangle2D bounds){
        double width = bounds.getWidth();
        double height = bounds.getHeight();
        double startX = width * start.getXEscalator();
        double startY = height * start.getYEscalator();
        double endX = width * end.getXEscalator();
        double endY = height * end.getYEscalator();
        return  new Line2D.Double(startX,startY,endX,endY);
    }
}
