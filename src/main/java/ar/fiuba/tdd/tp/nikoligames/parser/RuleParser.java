package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
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
    @SuppressWarnings("CPD-START")

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

    private List<Position> getRegion(JSONObject regionObject, String regionKey) {
        ArrayList<Position> positionsList = new ArrayList<Position>();
        JSONArray regionObj = (JSONArray) regionObject.get(regionKey);
        for (int j = 0; j < regionObj.size(); j++) {
            JSONArray regioCellObj = (JSONArray) regionObj.get(j);
            int row = (int) (long) regioCellObj.get(0);
            int col = (int) (long) regioCellObj.get(1);
            positionsList.add(new ClassicPosition(row, col));
        }
        return positionsList;
    }

    private RuleConfig parseRule(JSONObject ruleObj) throws Exception {
        String definition = (String) ruleObj.get(RULE_DEFINITION);

        RuleConfig ruleConfig = new RuleConfig(definition);

        List<Position> regionListPosition = getRegion(ruleObj, RULE_REGION);
        for (Position pos : regionListPosition) {
            ruleConfig.addCellToRegion(pos.getRow(), pos.getColumn());
        }
        if (ruleObj.containsKey(RULE_OPERATION_VALUE)) {
            String ruleValue = (String) ruleObj.get(RULE_OPERATION_VALUE);
            ruleConfig.setValue(ruleValue);
        }

        if (ruleObj.containsKey(RULE_REGION_lIST)) {
            JSONArray regionsObjs = (JSONArray) ruleObj.get(RULE_REGION_lIST);
            for (int j = 0; j < regionsObjs.size(); j++) {
                JSONObject regionObjs = (JSONObject) regionsObjs.get(j);
                regionListPosition = getRegion(ruleObj, RULE_REGION);
                ruleConfig.addRegionToRegionListPosition(regionListPosition);
            }
        }

        if (ruleObj.containsKey(RULE_ADJACENT)) {
            List<Position> adjacentListPosition = getRegion(ruleObj, RULE_ADJACENT);
            for (Position pos : adjacentListPosition) {
                ruleConfig.addCellToAdjacentRegion(pos.getRow(), pos.getColumn());
            }
        }
        return ruleConfig;

    }


}
