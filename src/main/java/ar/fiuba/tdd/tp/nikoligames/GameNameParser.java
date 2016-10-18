package ar.fiuba.tdd.tp.nikoligames;

import org.json.simple.JSONObject;

/**
 * Created by german on 10/18/2016.
 */
public class GameNameParser {
    private static final String DEFAULT_GAME_NAME = "NIKORI GAME";
    public static final String GAME_NAME = "game_name";

    public static String parseGameName(JSONObject jsonObject) {
        if (jsonObject.containsKey(GAME_NAME)) {
            return (String) jsonObject.get(GAME_NAME);
        }
        return DEFAULT_GAME_NAME;
    }


}
