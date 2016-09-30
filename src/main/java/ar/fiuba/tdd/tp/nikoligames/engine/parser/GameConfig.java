package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.ValidInputManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;

/**
 * Created by german on 9/30/2016.
 */
public interface GameConfig {
    void addRule(Rule rule);

    void addInitialCell(int row, int col, Cell cell);

    String getName();

    ConcreteBoard getBoard();

    RuleManager getRuleManager();

    ValidInputManager getValidInputManager();
}
