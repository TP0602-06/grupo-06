package ar.fiuba.tdd.tp.nikoligames;


import ar.fiuba.tdd.tp.nikoligames.view.grids.FactoryGridView;
import ar.fiuba.tdd.tp.nikoligames.view.parentView.FactoryView;
import ar.fiuba.tdd.tp.nikoligames.view.parentView.View;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

/**
 * Created by mcapolupo on 18/9/16.
 */
public class Main {



    public static void main(String[] args) {

        FactoryView factoryView = new FactoryView();
        View view = factoryView.createDefaultWindow();

        FactoryGridView factoryGridView = new FactoryGridView();
        GridView gridView = factoryGridView.createDefaultBoard(7,10);

        view.add(gridView);

        view.setVisible(true);
    }
}
