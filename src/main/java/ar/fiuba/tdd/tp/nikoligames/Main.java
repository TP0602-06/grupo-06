package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.argsparserhelper.AbstractArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.argsparserhelper.ArgsParserHelper;
import ar.fiuba.tdd.tp.nikoligames.engine.GameMove.GameMove;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.reporter.ReportMovesJson;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;

import java.util.ArrayList;
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
            AbstractArgsParserHelper argsParserHelper = new ArgsParserHelper();
            argsParserHelper.parseArgs(args);

            GameFactory gameFactory = new GameFactory();
            Game game = gameFactory.createGame(argsParserHelper.getArgGameType(), argsParserHelper.getArgGameDifficulty());
            ReportMovesJson reporter = new ReportMovesJson();
            List<GameMove> moves = new ArrayList<>();
            GameMove move = new GameMove(1,"3",new Position(1,1));
            moves.add(move);
            System.out.print(reporter.makeReport(game,moves));
            FactoryGameView factoryView = new FactoryGameView();
            GameView view = factoryView.createDefaultGameView(game);

            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
