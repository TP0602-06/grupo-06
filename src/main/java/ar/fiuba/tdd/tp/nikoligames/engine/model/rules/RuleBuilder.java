package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;


import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;

import java.util.ArrayList;

public class RuleBuilder {

    private RuleDefinitionValidator validRuleDefinitions = new RuleDefinitionValidator();
    private String ruleDefinition;
    private ArrayList<Position> region = new ArrayList<Position>();
    private String value = "";

    public RuleBuilder(String ruleDefinition) throws Exception {
        this.setRuleDefinition(ruleDefinition);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addCellToRegion(int row, int col) {
        Position pos = new ClassicPosition(row, col);
        this.region.add(pos);
    }

    public Rule createRule(Board board) throws Exception {
        ArrayList<AbstractCell> listOfCells = new ArrayList<>();
        for (Position pos: this.region){
            listOfCells.add(board.getCell(pos));
        }
        Rule rule = this.validRuleDefinitions.createRule(ruleDefinition, listOfCells, value);
        return rule;
    }

    private void setRuleDefinition(String ruleDefinition) throws Exception {
        if (this.validRuleDefinitions.containsRule(ruleDefinition)) {
            this.ruleDefinition = ruleDefinition;
        } else {
            throw new Exception("the rule " + ruleDefinition + " is not defined! ");
        }
    }

}
