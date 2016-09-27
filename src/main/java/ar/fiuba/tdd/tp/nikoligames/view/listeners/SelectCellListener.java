package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.FocusCellViewHelper.AbstractFocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.FocusCellViewHelper.FocusCellViewHelper;

import java.awt.event.*;

import javax.swing.*;

/**
 * Esta clase se encarga del comportamiento de las celdas.
 */
public class SelectCellListener implements MouseListener {

    private final AbstractFocusGridViewHelper focusGridHelper;
    private AbstractFocusCellViewHelper focusCellViewHelper = new FocusCellViewHelper();

    public SelectCellListener(AbstractFocusGridViewHelper focusGridViewHelper){
        this.focusGridHelper = focusGridViewHelper;
    }
    private JButton getButton(MouseEvent event) {
        return (JButton) event.getSource();
    }

    public void mouseClicked(MouseEvent event) {
        //TODO cell selected to controller
    }

    public void mouseEntered(MouseEvent event) {

    }

    public void mouseExited(MouseEvent event) {

    }

    public void mousePressed(MouseEvent event) {
        setFocus(getButton(event));
    }

    public void mouseReleased(MouseEvent event) {
    }

    private void setFocus(JButton selectedButton){
        focusGridHelper.clearFocus();
        focusCellViewHelper.setFocus(selectedButton);
    }

    private void clearFocus(JButton button){
        focusCellViewHelper.clearFocus(button);
    }

}
