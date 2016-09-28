package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.parentview.View;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

/**
 * Created by german on 9/25/2016.
 */
public interface AbstractFactoryBoard {
    GridView createBoardView(Integer rows, Integer cols);
}
