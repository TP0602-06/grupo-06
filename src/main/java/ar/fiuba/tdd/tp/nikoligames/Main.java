package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;

public class Main {

    public static void main(String[] args) {

        FactoryGameView factoryView = new FactoryGameView();
        GameView view = factoryView.createDefaultGameView();

        view.setVisible(true);

        System.out.println("nikoli games :D");
    }
}
