package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.listeners.AbstractSelectValueListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

/**
 * Esta clase se encarga de crear celdas para que el usuario ingrese valores.
 */
interface InputGridFactory  {
    GridView createInputGrid();

    void addInputCells(GridView grid, AbstractSelectValueController controller);
}
