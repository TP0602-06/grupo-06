package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by german on 10/17/2016.
 */
public class JsonObjectFilePathParser {
    public static JSONObject getJsonObject(String filename) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Reader fileReader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
        return (JSONObject) jsonParser.parse(fileReader);
    }
}
