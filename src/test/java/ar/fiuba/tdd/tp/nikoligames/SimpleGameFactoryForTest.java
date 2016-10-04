package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.BoardImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.GameImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.inputmanager.ValidInputManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NoDuplicatesRule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SimpleGameFactoryForTest {

    private Integer rows = 2;
    private Integer cols = 2;
    public static final String one = "1";
    public static final String two = "2";

    public Game makeGame(){
        Board board = new BoardImplementation(rows,cols);
        fillBoard(board);
        List<Rule> rules = new ArrayList<>();
        Rule rule = new NoDuplicatesRule(makePositions());
        rules.add(rule);

        RuleManager rulesManager = new RuleManager(board,rules);
        HashSet<String> inputs = new HashSet<>();
        inputs.add(one);
        inputs.add(two);
        ValidInputManager inputManager = new ValidInputManager(inputs);

        return new GameImplementation(board,rulesManager,inputManager,"testGame");
    }

    private void fillBoard(Board board) {
        for (int i = 1; i <= board.getRows(); i++){
            for (int j = 1; j <= board.getCols(); j++){
                Cell cell = new Cell("",true,false);
                Position position = new ClassicPosition(i,j);
                board.setCell(position,cell);
            }
        }
    }

    private ArrayList<Position> makePositions(){
        ArrayList<Position> positions = new ArrayList<>();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++){
                Position position1 = new ClassicPosition(i,j);
                positions.add(position1);
            }
        }
        return positions;

    }
}
