package ar.fiuba.tdd.tp.nikoligames.parser.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.NotValidRuleException;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class RuleConfig {

    public static final String DEFAULT_STRING_VALUE = "";

    private List<Position> regionPositions = new ArrayList();
    private List<List<Position>> regionListPositions = new ArrayList();
    private List<Position> adjacentPositions = new ArrayList();

    private RuleType ruleDefinition;
    private String value = DEFAULT_STRING_VALUE;


    public RuleConfig(String ruleDefinition) throws Exception {
        this.setRuleDefinition(ruleDefinition);
    }

    public RuleType getRuleDefinition() {
        return ruleDefinition;
    }

    public void setRuleDefinition(String ruleDefinition) throws NotValidRuleException {
        this.ruleDefinition = RuleType.getRuleType(ruleDefinition);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<List<Position>> getRegionListPositions() {
        return regionListPositions;
    }

    public List<Position> getRegionPositions() {
        return regionPositions;
    }

    public List<Position> getAdjacentPositions() {
        return adjacentPositions;
    }

    public void setRegionPositions(List<Position> regionPositions) {
        this.regionPositions = regionPositions;
    }

    public void setRegionListPositions(List<List<Position>> regionListPositions) {
        this.regionListPositions = regionListPositions;
    }

    public void setAdjacentPositions(List<Position> adjacentPositions) {
        this.adjacentPositions = adjacentPositions;
    }

}
