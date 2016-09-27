package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.view.grids.FactoryGridView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.FactoryView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.View;

/**
 * Created by mcapolupo on 18/9/16.
 */
public class Main {



    public static void main(String[] args) {

        FactoryView factoryView = new FactoryView();
        View view = factoryView.createDefaultWindow();

        FactoryGridView factoryGridView = new FactoryGridView();

        factoryGridView.createDefaultBoard(7,10, view);

        //view.add(gridView);

        view.setVisible(true);
    }
}
