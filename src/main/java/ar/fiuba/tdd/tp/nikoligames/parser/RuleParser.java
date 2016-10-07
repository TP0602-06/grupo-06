package ar.fiuba.tdd.tp.nikoligames.parser;

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


    private RuleConfig parseRule(JSONObject ruleObj) throws Exception {
        String definition = (String) ruleObj.get(RULE_DEFINITION);

        RuleConfig ruleConfig = new RuleConfig(definition);

        JSONArray regionObj = (JSONArray) ruleObj.get("region");
        for (int j = 0; j < regionObj.size(); j++) {
            JSONArray regioCellObj = (JSONArray) regionObj.get(j);
            int row = (int) (long) regioCellObj.get(0);
            int col = (int) (long) regioCellObj.get(1);

            ruleConfig.addCellToRegion(row, col);
        }

        if (ruleObj.containsKey(RULE_OPERATION_VALUE)) {
            String ruleValue = (String) ruleObj.get(RULE_OPERATION_VALUE);
            ruleConfig.setValue(ruleValue);
        }

        return ruleConfig;
    }


}
