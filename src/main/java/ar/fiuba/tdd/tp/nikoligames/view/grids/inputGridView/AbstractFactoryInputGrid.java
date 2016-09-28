package ar.fiuba.tdd.tp.nikoligames.view.grids.inputGridView;

import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

/**
 * Esta clase se encarga de crear celdas para que el usuario ingrese valores.
 */
public interface AbstractFactoryInputGrid {
    GridView createInputGridForBoardView(GridView board);

}
