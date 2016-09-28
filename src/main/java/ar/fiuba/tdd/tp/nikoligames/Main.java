package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.view.parentview.FactoryView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.View;

public class Main {

    public static void main(String[] args) {

        FactoryView factoryView = new FactoryView();
        View view = factoryView.createDefaultGameView();

        view.setVisible(true);

        System.out.println("nikoli games :D");
    }
}
