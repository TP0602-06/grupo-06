package ar.fiuba.tdd.tp.nikoligames.acceptancetests;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.game.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.parser.AbstractParser;
import ar.fiuba.tdd.tp.nikoligames.parser.ConcreteParser;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Andres on 18/10/2016.
 */
public class GameSetup {
    public Game setup(String boardFilePath) throws Exception {
        GameFactory gameFactory = new GameFactory();
        AbstractParser gameConfigParser = new ConcreteParser(boardFilePath);

        GameConfig gameConfig = gameConfigParser.parse();
        Game game = gameFactory.createGame(gameConfig);
        return game;
    }
    public static void fillGame(Game game, List<String> values){
        Iterator<String> iterator = values.iterator();
        int row = 1;
        int col = 1;
        while (iterator.hasNext()){
            String value = iterator.next();
            if (!value.isEmpty()){
                game.changeNodeValue(new ClassicPosition(row, col), value);
            }
            if (col >= game.getDrawableBoard().getCols()){
                col = 1;
                row++;
            }else {
                col ++;
            }
        }
    }
}
