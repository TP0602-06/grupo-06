package ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview;

import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

/**
 * Esta clase se encarga de crear celdas para que el usuario ingrese valores.
 */
public interface AbstractFactoryInputGrid {
    GridView createInputGridForBoardView(GridView board);

}
