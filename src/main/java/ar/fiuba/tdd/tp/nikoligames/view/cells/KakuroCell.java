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

    private Color backgroundColor = ColorSet.INVALID_BACKGROUND ;
    private Color foregroundColor = ColorSet.RULE_NUMBER;

    public KakuroCell() {
        setBackground(backgroundColor);
        setLayout(new BorderLayout());
        setEnabled(false);
    }

    private JLabel makeLabel(Integer value) {
        JLabel label = new JLabel(String.valueOf(value));
        label.setForeground(foregroundColor);
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
        g2.setColor(foregroundColor);
        g2.setStroke(new BasicStroke(2f));
        Rectangle2D bounds = graphic.getClipBounds();
        g2.draw(new Line2D.Double(0, 0, bounds.getWidth(), bounds.getHeight()));
    }

    @Override
    public void clearFocus() {
        this.setBackground(backgroundColor);
    }
}
