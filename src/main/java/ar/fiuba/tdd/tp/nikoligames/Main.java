package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.argsparserhelper.AbstractArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.argsparserhelper.ArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.engine.model.Game;
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
        try {
            argsParserHelper.parseArgs(args);

            GameConfigParser gameConfigParser = new GameConfigParser(argsParserHelper.getArg0GameFile());

            GameConfig gameConfig = gameConfigParser.parse();
            Game game = new Game(gameConfig);

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