package ar.fiuba.tdd.tp.nikoligames.reportertest;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.model.game.ConcreteGameAdmitsInvalidPlays;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region.NoDuplicatesRule;

import java.util.ArrayList;
import java.util.List;

public class SimpleGameFactoryForTest {

    private Integer rows = 2;
    private Integer cols = 2;
    public static final String one = "1";
    public static final String two = "2";

    public Game makeGame() throws Exception {
        Board board = new ConcreteBoard(rows, cols);

        List<Rule> rules = new ArrayList<>();
        Rule rule = new NoDuplicatesRule(board.getAllNodes());
        rules.add(rule);

        return new ConcreteGameAdmitsInvalidPlays(board, rules);
    }

}
