package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import java.awt.*;
import javax.swing.*;


/**
 * Created by fedebrasburg on 10/17/16.
 */
public class CenterValuePainter extends CellPainterWithValue{

    public CenterValuePainter(String value) {
        super(value, JLabel.CENTER);
        setAnchor(GridBagConstraints.CENTER);
    }
}
