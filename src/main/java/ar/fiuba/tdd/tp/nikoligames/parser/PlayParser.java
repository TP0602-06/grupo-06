package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.play.AbstractPlay;
import org.json.simple.JSONObject;

/**
 * Created by german on 10/16/2016.
 */
public class PlayParser {
    public static final String NUM_KEY = "number";
    private static final String BOARDSTATUS_KEY = "boardstatus";

    public static JSONObject toJson(AbstractPlay play){
        JSONObject moveJson = new JSONObject();
        moveJson.put(NUM_KEY, play.getNumber());
        moveJson.put(BOARDSTATUS_KEY, play.getBoardStatus());

        return moveJson;
    }
}
