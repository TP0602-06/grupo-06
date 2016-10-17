package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.ChangeNodeValuePlay;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfigParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import utils.JsonObjectFilePathParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/16/2016.
 */
public class PlayParser {
    public static final String POSITION_KEY = "position";
    public static final String NUM_KEY = "number";
    public static final String BOARDSTATUS_KEY = "boardStatus";
    public static final String VALUE_KEY = "value";

    public static JSONObject toJson(AbstractPlay play) {
        JSONObject moveJson = new JSONObject();
        moveJson.put(NUM_KEY, play.getNumber());
        moveJson.put(BOARDSTATUS_KEY, play.getBoardStatus());

        return moveJson;
    }

    private static AbstractPlay parse(JSONObject object, Game game) throws Exception {

        int number = (int) (long) object.get(NUM_KEY);

        JSONArray positionJsonArrayObj = (JSONArray) object.get(POSITION_KEY);
        SizeConfig positionConfig = SizeConfigParser.parse(positionJsonArrayObj);

        Position position = new ClassicPosition(positionConfig.getRows(), positionConfig.getCols());

        if (object.containsKey(VALUE_KEY)) {
            String value = (String) object.get(VALUE_KEY);
            AbstractPlay play = new ChangeNodeValuePlay(game, number, value, position);
            return play;
        }

        throw new Exception("not a valid play");
    }

    public static List<AbstractPlay> parse(String inputFileName, Game game) throws IOException, ParseException {
        JSONObject jsonObject = JsonObjectFilePathParser.getJsonObject(inputFileName);

        JSONArray playJsonArray = (JSONArray) jsonObject.get("plays");
        List<AbstractPlay> plays = new ArrayList<AbstractPlay>();
        for (int i = 0; i < playJsonArray.size(); i++) {
            JSONObject playJsonObject = (JSONObject) playJsonArray.get(i);

            try {
                AbstractPlay play = PlayParser.parse(playJsonObject, game);
                plays.add(play);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return plays;
    }
}
