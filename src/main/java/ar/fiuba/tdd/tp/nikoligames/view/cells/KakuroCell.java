package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 * Esta es la representacion grafica de una celda kakuro.
 */
public class KakuroCell extends CellView {

    public KakuroCell() {
        setBackground(ColorSet.INVALID_BACKGROUND);
        setLayout(new BorderLayout());
        setEnabled(false);
    }

    private JLabel makeLabel(Integer value) {
        JLabel label = new JLabel(String.valueOf(value));
        label.setForeground(ColorSet.NORMAL_BACKGROUND);
        return label;
    }

    public void setTop(Integer topValue) {
        JLabel label = makeLabel(topValue);
        label.setHorizontalAlignment(JLabel.RIGHT);
        add(label, BorderLayout.PAGE_START);

    }

    public void setBottom(Integer bottomValue) {
        JLabel label = makeLabel(bottomValue);
        label.setHorizontalAlignment(JLabel.LEFT);
        add(makeLabel(bottomValue), BorderLayout.PAGE_END);
    }

    @Override
    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        Graphics2D g2 = (Graphics2D) graphic;
        g2.setColor(ColorSet.NORMAL_BACKGROUND);
        g2.setStroke(new BasicStroke(2f));
        Rectangle2D bounds = graphic.getClipBounds();
        g2.draw(new Line2D.Double(0, 0, bounds.getWidth(), bounds.getHeight()));
    }
}
