package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;

import java.awt.*;
import javax.swing.JLabel;

/**
 * Estos son pintores que agregan alguna pista en texto en la celda.
 */
public abstract class CellPainterWithValue implements CellPainter {
    private String value;
    private Integer alignment;
    private Integer anchor;
    private Integer ipadx;
    private Integer ipady;

    public CellPainterWithValue(String value, Integer alignment) {
        this.value = value;
        this.alignment = alignment;
    }

    public void paintCell(Paintable paintable) {
        if (!emptyMargins(paintable)) {
            paintable.setMargin(new Insets(0, 0, 0, 0));
            paintable.setLayout(new GridBagLayout());
        }
        insertClueTo(paintable);
    }

    private boolean emptyMargins(Paintable cell) {
        Insets marginInsets = cell.getMargin();
        return allZero(marginInsets);
    }

    private boolean allZero(Insets insets) {
        boolean topZero = insets.top == 0;
        boolean leftZero = insets.left == 0;
        boolean bottomZero = insets.bottom == 0;
        boolean rightZero = insets.right == 0;
        return topZero && leftZero && bottomZero && rightZero;
    }

    protected void setAnchor(Integer anchor) {
        this.anchor = anchor;
    }

    protected void setIpadx(Integer ipadx) {
        this.ipadx = ipadx;
    }

    protected void setIpady(Integer ipady) {
        this.ipady = ipady;
    }

    private GridBagConstraints makeConstraint() {
        // src: http://stackoverflow.com/questions/18221632/put-4-jlabel-at-corners-of-a-jframe
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = anchor;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.ipadx = ipadx;
        constraints.ipady = ipady;
        return constraints;
    }

    private void insertClueTo(Paintable cell) {
        JLabel label = makeLabel();
        label.setForeground(ColorSet.CLUE);
        label.setHorizontalAlignment(alignment);
        cell.add(label, makeConstraint());
    }

    private JLabel makeLabel() {
        JLabel label = new JLabel(value);
        label.setForeground(ColorSet.RULE_NUMBER);
        return label;
    }
}
