package ar.fiuba.tdd.tp.nikoligames.engine.parser;


import ar.fiuba.tdd.tp.nikoligames.engine.model.ValidInputManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;

import java.util.HashSet;

public class ConcreteGameConfig {

    private ConcreteBoard board;
    RuleManager ruleManager;
    private String name;

    private ValidInputManager validInputManager;

    public ConcreteGameConfig(String name, SizeConfig sizeConfig, HashSet<String> validInputs) {
        this.board = new ConcreteBoard(sizeConfig.getRows(), sizeConfig.getCols());
        this.ruleManager = new RuleManager(this.board);
        this.name = name;
        this.validInputManager = new ValidInputManager(validInputs);
    }

    public void addRule(Rule rule) {
        this.ruleManager.addRule(rule);
    }

    public void addInitialCell(int row, int col, Cell cell) {
        this.board.setCell(row, col, cell);
    }

    public String getName() {
        return name;
    }

    public ConcreteBoard getBoard() {
        return board;
    }

    public RuleManager getRuleManager() {
        return ruleManager;
    }

    public ValidInputManager getValidInputManager() {
        return validInputManager;
    }

}
