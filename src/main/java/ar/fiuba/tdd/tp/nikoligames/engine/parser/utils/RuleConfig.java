package ar.fiuba.tdd.tp.nikoligames.engine.parser.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleDefinitionValidator;

import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class RuleConfig {
    private RuleDefinitionValidator validRuleDefinitions = new RuleDefinitionValidator();

    private List<Position> regionPositions;
    private String ruleDefinition;
    private String value = "";

    public RuleConfig(String ruleDefinition) throws Exception {
        this.setRuleDefinition(ruleDefinition);
    }

    public String getRuleDefinition() {
        return ruleDefinition;
    }

    public void setRuleDefinition(String ruleDefinition) throws Exception {
        this.ckeckRuleDefinition(ruleDefinition);
        this.ruleDefinition = ruleDefinition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addCellToRegion(int row, int col) {
        Position pos = new ClassicPosition(row, col);
        this.regionPositions.add(pos);
    }

    public List<Position> getRegionPositions() {
        return regionPositions;
    }

    private void ckeckRuleDefinition(String ruleDefinition) throws Exception {
        if (!this.validRuleDefinitions.containsRule(ruleDefinition)) {
            throw new Exception("the rule " + ruleDefinition + " is not defined! ");
        }
    }
}
