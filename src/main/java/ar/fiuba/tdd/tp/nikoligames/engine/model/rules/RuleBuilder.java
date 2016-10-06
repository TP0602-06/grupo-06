package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;


import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.AbstractCell;

import java.util.ArrayList;

public class RuleBuilder {
    protected ArrayList<AbstractCell> listOfCells = new ArrayList<AbstractCell>();
    private RuleType ruleDefinition;
    private String value = "";

    public RuleBuilder(String ruleDefinition) throws Exception {
        this.setRuleDefinition(ruleDefinition);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addCellToRegion(AbstractCell cell) {
        this.listOfCells.add(cell);
    }

    public Rule createRule() throws Exception {
        Rule rule = ruleDefinition.createRule(listOfCells, value);
        return rule;
    }

    private void setRuleDefinition(String ruleDefinition) throws Exception {
        for (RuleType ruleType : RuleType.values()) {
            if (ruleType.isRule(ruleDefinition)) {
                this.ruleDefinition = ruleType;
                break;
            }
        }
    }

}
