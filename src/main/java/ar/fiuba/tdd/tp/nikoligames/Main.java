package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.parser.AbstractParser;
import ar.fiuba.tdd.tp.nikoligames.parser.ConcreteParser;
import ar.fiuba.tdd.tp.nikoligames.parser.argsparserhelper.AbstractArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.parser.argsparserhelper.ArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameViewImplementation;

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
            AbstractParser gameConfigParser = new ConcreteParser(gameJsonFilePath);

            GameConfig gameConfig = gameConfigParser.parse();
            Game game = gameFactory.createGame(gameConfig);

            FactoryGameView factoryView = new FactoryGameViewImplementation();
            GameView view = factoryView.createDefaultGameView(game, gameConfig.getValidInputs());

            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//ReportMovesJson reporter = new ReportMovesJson();
//List<ChangeNodeValuePlay> moves = new ArrayList<>();
//ChangeNodeValuePlay move = new ChangeNodeValuePlay(1,"3",new ClassicPosition(1,1));
//moves.add(move);
//System.out.print(reporter.makeReport(game,moves));