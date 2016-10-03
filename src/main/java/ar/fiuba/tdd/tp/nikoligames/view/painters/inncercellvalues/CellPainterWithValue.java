package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Estos son pintores que agregan alguna pista en texto en la celda.
 */
public abstract class CellPainterWithValue implements CellPainter {
    private String value;
    private Integer alignment;

    public CellPainterWithValue(String value, Integer alignment) {
        this.value = value;
        this.alignment = alignment;
    }

    public void paintCell(CellView cell) {
        if (!emptyMargins(cell)) {
            cell.setMargin(new Insets(0, 0, 0, 0));
            cell.setLayout(new GridBagLayout());
        }
        insertClueTo(cell);
    }

    private boolean emptyMargins(CellView cell) {
        Insets marginInsets = cell.getMargin();
        return allZero(marginInsets);
    }

    private boolean allZero(Insets insets){
        boolean topZero = insets.top == 0;
        boolean leftZero = insets.left == 0;
        boolean bottomZero = insets.bottom == 0;
        boolean rightZero = insets.right == 0;
        return  topZero && leftZero && bottomZero && rightZero;
    }

    public abstract Integer getAnchor();
    public abstract Integer getIpadx();
    public abstract Integer getIpady();

    public  GridBagConstraints makeConstraint(){
        // src: http://stackoverflow.com/questions/18221632/put-4-jlabel-at-corners-of-a-jframe
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = getAnchor();
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0,0,0,0);
        constraints.ipadx = getIpadx();
        constraints.ipady = getIpady();
        return constraints;
    }

    private void insertClueTo(CellView cell) {
        JLabel label = makeLabel();
        label.setHorizontalAlignment(alignment);
        cell.add(label, makeConstraint());
    }

    private JLabel makeLabel() {
        JLabel label = new JLabel(value);
        label.setForeground(ColorSet.RULE_NUMBER);
        return label;
    }
}
