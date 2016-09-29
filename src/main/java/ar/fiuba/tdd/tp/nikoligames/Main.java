package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.argsparserhelper.AbstractArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.argsparserhelper.ArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;

/**
 * Responsabilidades:
 * 1.Invocar al parser para parsear los argumentos del programa
 * 2.Crear el modelo del juego
 * 3.Crear la vista del juego
 */
public class Main {
    public static void main(String[] args) {

        try {
            AbstractArgsParserHelper argsParserHelper = new ArgsParserHelper();
            argsParserHelper.parseArgs(args);

            GameFactory gameFactory = new GameFactory();
            Game game = gameFactory.createGame(argsParserHelper.getArgGameType(), argsParserHelper.getArgGameConfigFile());

            FactoryGameView factoryView = new FactoryGameView();
            GameView view = factoryView.createDefaultGameView(game);

            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}