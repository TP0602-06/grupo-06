package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.game.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.parser.AbstractParser;
import ar.fiuba.tdd.tp.nikoligames.parser.ConcreteParser;
import ar.fiuba.tdd.tp.nikoligames.parser.PlayParser;
import ar.fiuba.tdd.tp.nikoligames.parser.argsparserhelper.AbstractArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.parser.argsparserhelper.ArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.reporter.AbstractPlaysReporter;
import ar.fiuba.tdd.tp.nikoligames.reporter.ReportPlaysJson;
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

    public static void main(String[] args) {
        try {
            AbstractArgsParserHelper argsParserHelper = parseProgramArgs(args);

            String gameJsonFilePath = argsParserHelper.getGameFileName();

            GameConfig gameConfig = parseJsonGameFile(gameJsonFilePath);

            Game game = getGame(gameConfig);

            if (argsParserHelper.hasInputPlaysFile()) {
                generateReport(argsParserHelper, game);
                return;
            }
            createView(gameConfig, game);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GameConfig parseJsonGameFile(String gameJsonFilePath) throws Exception {
        AbstractParser gameConfigParser = new ConcreteParser(gameJsonFilePath);

        return gameConfigParser.parse();
    }

    public static AbstractArgsParserHelper parseProgramArgs(String[] args) throws Exception {
        AbstractArgsParserHelper argsParserHelper = new ArgsParserHelper();
        argsParserHelper.parseArgs(args);
        return argsParserHelper;
    }

    public static void createView(GameConfig gameConfig, Game game) throws Exception {
        FactoryGameView factoryView = new FactoryGameViewImplementation();
        GameView view = factoryView.createDefaultGameView(game, gameConfig.getValidInputs());
        view.setVisible(true);
    }

    public static void generateReport(AbstractArgsParserHelper argsParserHelper, Game game) throws Exception {
        String inputFileName = argsParserHelper.getInputPlaysFileName();
        String outputFileName = argsParserHelper.getOutputPlaysFileName();

        List<AbstractPlay> plays = PlayParser.parse(inputFileName, game);

        AbstractPlaysReporter reporter = new ReportPlaysJson();
        reporter.writeReport(game, plays, outputFileName);
    }

    public static Game getGame(GameConfig gameConfig) throws Exception {
        GameFactory gameFactory = new GameFactory();
        return gameFactory.createGame(gameConfig);
    }
}