package ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.FocusCellViewHelper;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;

import java.awt.*;

/**
 * Created by german on 9/27/2016.
 */
public class FocusCellViewHelper implements AbstractFocusCellViewHelper {
    public void setFocus(Component button){
        button.setBackground(ColorSet.HOVER);
    }

    public void clearFocus(Component button){
        button.setBackground(ColorSet.NORMAL_BACKGROUND);
    }
}
