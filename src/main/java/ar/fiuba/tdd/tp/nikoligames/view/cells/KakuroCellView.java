package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;


/**
 * Esta es la representacion grafica de una celda kakuro.
 */
public class KakuroCellView extends CellView {

    private Color backgroundColor = ColorSet.INVALID_BACKGROUND;
    private Color foregroundColor = ColorSet.RULE_NUMBER;

    public KakuroCellView() {
        setBackground(backgroundColor);
        setLayout(new BorderLayout());
        setEnabled(false);
        setMargin(new Insets(0, 0, 0, 0));
    }

    private JLabel makeLabel(String value) {
        JLabel label = new JLabel(value);
        label.setForeground(foregroundColor);
        return label;
    }

    public void setTop(String topValue) {
        makeClueCell(topValue, JLabel.RIGHT, BorderLayout.NORTH);
    }

    public void setBottom(String bottomValue) {
        makeClueCell(bottomValue, JLabel.LEFT, BorderLayout.SOUTH);
    }

    private void makeClueCell(String bottomValue, int alignment, String pageEnd) {
        JLabel label = makeLabel(bottomValue);
        label.setHorizontalAlignment(alignment);
        add(label, pageEnd);
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
