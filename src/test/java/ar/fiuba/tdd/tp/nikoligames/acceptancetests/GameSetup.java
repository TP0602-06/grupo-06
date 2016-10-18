package ar.fiuba.tdd.tp.nikoligames.acceptancetests;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
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

    public static void fillGame(Game game, List<String> values) {
        Iterator<String> iterator = values.iterator();
        int row = 1;
        int col = 1;
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (!value.isEmpty()) {
                game.changeNodeValue(new ClassicPosition(row, col), value);
            }
            if (col >= game.getDrawableBoard().getCols()) {
                col = 1;
                row++;
            } else {
                col++;
            }
        }
    }

    public static void processCircuit(Game game, List<List<Integer>> circuit) {
        Iterator<List<Integer>> circuitIterator = circuit.iterator();

        while (circuitIterator.hasNext()) {

            List<Integer> edge = circuitIterator.next();
            Position position0 = getPosition(edge, 0);
            Position position1 = getPosition(edge, 1);
            game.createUndirectedEdge(position0, position1);
        }
    }

    public static void processContunuosCircuit(Game game, List<List<Integer>> circuit) {
        Iterator<List<Integer>> circuitIterator = circuit.iterator();

        List<Integer> previusPositionList = circuitIterator.next();
        Position previusPosition = getPosition(previusPositionList);

        while (circuitIterator.hasNext()) {
            List<Integer> nextPositionList = circuitIterator.next();
            Position nextPosition = getPosition(nextPositionList);

            game.createUndirectedEdge(previusPosition, nextPosition);

            previusPosition = nextPosition;
        }
    }

    public static Position getPosition(List<Integer> positionList) {
        return new ClassicPosition(positionList.get(0), positionList.get(1));
    }

    public static Position getPosition(List<Integer> edge, int number) {
        List<Integer> positionList = edge.subList((0 + 2 * number), (2 + 2 * number));
        return new ClassicPosition(positionList.get(0), positionList.get(1));
    }
}
