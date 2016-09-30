package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by german on 9/30/2016.
 */
public class RuleParser {

    public static final String RULE_DEFINITION = "definition";
    public static final String RULE_OPERATION_VALUE = "value";


    public Rule parseRule(JSONObject ruleObj) throws Exception {

        String definition = (String) ruleObj.get(RULE_DEFINITION);

        RuleBuilder ruleBuilder = new RuleBuilder(definition);

        JSONArray regionObj = (JSONArray) ruleObj.get("region");
        for (int j = 0; j < regionObj.size(); j++) {
            JSONArray regioCellObj = (JSONArray) regionObj.get(j);
            int row = (int) (long) regioCellObj.get(0);
            int col = (int) (long) regioCellObj.get(1);
            ruleBuilder.addCellToRegion(row, col);
        }

        if (ruleObj.containsKey(RULE_OPERATION_VALUE)) {
            String ruleValue = (String) ruleObj.get(RULE_OPERATION_VALUE);
            ruleBuilder.setValue(ruleValue);
        }

        return ruleBuilder.createRule();
    }
}
