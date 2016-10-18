package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfigParser;
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

    public List<RuleConfig> parseRules(JSONObject jsonObject) throws Exception {
        List<RuleConfig> rules = new ArrayList<RuleConfig>();
        RuleParser ruleParser = new RuleParser();

        JSONObject rulesObj = (JSONObject) jsonObject.get(RULES);
        JSONArray ruleValues = (JSONArray) rulesObj.get(RULE_VALUES);

        Iterator<JSONObject> iterator = ruleValues.iterator();
        while (iterator.hasNext()) {
            JSONObject ruleObj = iterator.next();
            RuleConfig rule = ruleParser.parseRule(ruleObj);
            rules.add(rule);
        }
        return rules;
    }

    @SuppressWarnings("CPD-START")
    private List<Position> getRegion(JSONObject regionObject, String regionKey) {
        ArrayList<Position> positionsList = new ArrayList<Position>();
        JSONArray regionObj = (JSONArray) regionObject.get(regionKey);
        for (int j = 0; j < regionObj.size(); j++) {
            JSONArray regioCellObj = (JSONArray) regionObj.get(j);
            SizeConfig position = SizeConfigParser.parse(regioCellObj);
            positionsList.add(new ClassicPosition(position.getRows(), position.getCols()));
        }
        return positionsList;
    }

    @SuppressWarnings("CPD-END")

    private RuleConfig parseRule(JSONObject ruleObj) throws Exception {
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
            List<Position> adjacentListPosition = getRegion(ruleObj, RULE_ADJACENT);
            for (Position pos : adjacentListPosition) {
                ruleConfig.addNodePositionToAdjacentRegion(pos.getRow(), pos.getColumn());
            }
        }
    }

    private void parseListOfRegionsParameter(JSONObject ruleObj, RuleConfig ruleConfig) {
        if (ruleObj.containsKey(RULE_REGION_lIST)) {
            List<Position> regionListPosition;

            JSONArray regionsObjs = (JSONArray) ruleObj.get(RULE_REGION_lIST);
            for (int j = 0; j < regionsObjs.size(); j++) {
                JSONObject regionObjs = (JSONObject) regionsObjs.get(j);
                regionListPosition = getRegion(regionObjs, RULE_REGION);
                ruleConfig.addRegionToRegionListPosition(regionListPosition);
            }
        }
    }

    private void parseRuleValueParameter(JSONObject ruleObj, RuleConfig ruleConfig) {
        if (ruleObj.containsKey(RULE_OPERATION_VALUE)) {
            String ruleValue = (String) ruleObj.get(RULE_OPERATION_VALUE);
            ruleConfig.setValue(ruleValue);
        }
    }

    @SuppressWarnings("CPD-START")
    private void parseRuleRegionParameter(JSONObject ruleObj, RuleConfig ruleConfig) {

        if (ruleObj.containsKey(RULE_REGION)) {
            List<Position> regionListPosition = getRegion(ruleObj, RULE_REGION);
            for (Position pos : regionListPosition) {
                ruleConfig.addCellToRegion(pos.getRow(), pos.getColumn());
            }
        }
    }
}
