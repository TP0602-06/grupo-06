package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public class RuleParser {

    public static final String RULES = "rules";
    public static final String RULE_VALUES = "values";
    public static final String RULE_DEFINITION = "definition";
    public static final String RULE_OPERATION_VALUE = "value";
    public static final String RULE_REGION = "region";
    public static final String RULE_REGION_lIST = "region_list";
    public static final String RULE_ADJACENT = "adjacents";

    @SuppressWarnings("CPD-START")
    public List<RuleConfig> parseRules(JSONObject jsonObject) throws Exception {
        List<RuleConfig> rules = new ArrayList<RuleConfig>();
        RuleParser ruleParser = new RuleParser();

        if (jsonObject.containsKey(RULES)) {
            JSONObject rulesObj = (JSONObject) jsonObject.get(RULES);

            if (!rulesObj.containsKey(RULE_VALUES)) {
                throw new Exception("Rules -> Invalid Format, it must contain JSONArray 'values' ");
            }
            JSONArray ruleValues = (JSONArray) rulesObj.get(RULE_VALUES);

            Iterator<JSONObject> iterator = ruleValues.iterator();
            while (iterator.hasNext()) {
                JSONObject ruleObj = iterator.next();
                RuleConfig rule = ruleParser.parseRule(ruleObj);
                rules.add(rule);
            }
        }
        return rules;
    }


    private RuleConfig parseRule(JSONObject ruleObj) throws Exception {
        if (!ruleObj.containsKey(RULE_DEFINITION)) {
            throw new Exception("Rule must have 'definition' String ");
        }
        String definition = (String) ruleObj.get(RULE_DEFINITION);

        RuleConfig ruleConfig = new RuleConfig(definition);

        parseRuleRegionParameter(ruleObj, ruleConfig);
        parseRuleValueParameter(ruleObj, ruleConfig);
        parseListOfRegionsParameter(ruleObj, ruleConfig);
        parseAdjacentListPositionsList(ruleObj, ruleConfig);

        return ruleConfig;
    }

    private void parseAdjacentListPositionsList(JSONObject ruleObj, RuleConfig ruleConfig) {
        if (ruleObj.containsKey(RULE_ADJACENT)) {
            List<Position> adjacentListPosition = JsonArrayOfPositionsParser.parseJsonObjectListOfPositions(ruleObj, RULE_ADJACENT);
            ruleConfig.setAdjacentPositions(adjacentListPosition);
        }
    }

    private void parseListOfRegionsParameter(JSONObject ruleObj, RuleConfig ruleConfig) {
        if (ruleObj.containsKey(RULE_REGION_lIST)) {
            List<List<Position>> allRegionsList = new ArrayList<List<Position>>();

            JSONArray regionsObjs = (JSONArray) ruleObj.get(RULE_REGION_lIST);

            for (int j = 0; j < regionsObjs.size(); j++) {
                JSONArray regionObjs = (JSONArray) regionsObjs.get(j);
                List<Position> regionListPosition = JsonArrayOfPositionsParser.parseJsonArrayOfPositions(regionObjs);
                allRegionsList.add(regionListPosition);
            }
            ruleConfig.setRegionListPositions(allRegionsList);
        }
    }

    private void parseRuleValueParameter(JSONObject ruleObj, RuleConfig ruleConfig) {
        if (ruleObj.containsKey(RULE_OPERATION_VALUE)) {
            String ruleValue = (String) ruleObj.get(RULE_OPERATION_VALUE);
            ruleConfig.setValue(ruleValue);
        }
    }

    private void parseRuleRegionParameter(JSONObject ruleObj, RuleConfig ruleConfig) {

        if (ruleObj.containsKey(RULE_REGION)) {
            List<Position> regionPositions = JsonArrayOfPositionsParser.parseJsonObjectListOfPositions(ruleObj, RULE_REGION);
            ruleConfig.setRegionPositions(regionPositions);
        }
    }
}
