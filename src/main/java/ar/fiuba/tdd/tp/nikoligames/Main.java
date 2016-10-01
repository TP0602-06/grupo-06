package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.argsparserhelper.AbstractArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.argsparserhelper.ArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.engine.model.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.GameImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfigParser;

/**
 * Responsabilidades:
 * 1.Invocar al parser para parsear los argumentos del programa
 * 2.Crear el modelo del juego
 * 3.Crear la vista del juego
 */
public class Main {

    public static void main(String[] args) {
        AbstractArgsParserHelper argsParserHelper = new ArgsParserHelper();
        GameFactory gameFactory = new GameFactory();

        try {
            argsParserHelper.parseArgs(args);
            String gameJsonFilePath = argsParserHelper.getGameFile();
            GameConfigParser gameConfigParser = new GameConfigParser(gameJsonFilePath);

            GameConfig gameConfig = gameConfigParser.parse();
            Game game = gameFactory.createGame(gameConfig);

            //FactoryGameView factoryView = new FactoryGameView();
            //GameView view = factoryView.createDefaultGameView(game);

            //view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//ReportMovesJson reporter = new ReportMovesJson();
//List<Play> moves = new ArrayList<>();
//Play move = new Play(1,"3",new ClassicCoordinates(1,1));
//moves.add(move);
//System.out.print(reporter.makeReport(game,moves));