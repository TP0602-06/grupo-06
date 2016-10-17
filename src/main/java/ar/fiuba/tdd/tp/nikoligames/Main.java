package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.engine.reporter.AbstractPlaysReporter;
import ar.fiuba.tdd.tp.nikoligames.engine.reporter.ReportPlaysJson;
import ar.fiuba.tdd.tp.nikoligames.parser.AbstractParser;
import ar.fiuba.tdd.tp.nikoligames.parser.ConcreteParser;
import ar.fiuba.tdd.tp.nikoligames.parser.PlayParser;
import ar.fiuba.tdd.tp.nikoligames.parser.argsparserhelper.AbstractArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.parser.argsparserhelper.ArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameViewImplementation;

import java.util.List;

/**
 * Responsabilidades:
 * 1.Invocar al parser para parsear los argumentos del programa
 * 2.Crear el modelo del juego
 * 3.Crear la vista del juego
 */
public class Main {

    public static final String OUTPUT_JSON = "output.json";

    public static void main(String[] args) {

        AbstractArgsParserHelper argsParserHelper = new ArgsParserHelper();
        GameFactory gameFactory = new GameFactory();

        try {
            argsParserHelper.parseArgs(args);
            String gameJsonFilePath = argsParserHelper.getGameFileName();
            AbstractParser gameConfigParser = new ConcreteParser(gameJsonFilePath);

            GameConfig gameConfig = gameConfigParser.parse();
            Game game = gameFactory.createGame(gameConfig);

            if (argsParserHelper.hasInputPlaysFile()) {
                String inputFileName = argsParserHelper.getInputPlaysFileName();
                List<AbstractPlay> plays = PlayParser.parse(inputFileName, game);

                AbstractPlaysReporter reporter = new ReportPlaysJson();
                reporter.writeReport(game, plays, OUTPUT_JSON);
                return;
            }
            FactoryGameView factoryView = new FactoryGameViewImplementation();
            GameView view = factoryView.createDefaultGameView(game, gameConfig.getValidInputs());
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}