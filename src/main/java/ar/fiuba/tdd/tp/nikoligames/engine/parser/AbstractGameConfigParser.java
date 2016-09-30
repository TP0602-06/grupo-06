package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by mcapolupo on 20/9/16.
 * All implementations know how to parse any file type to create a {@link GameConfig}
 */
public interface AbstractGameConfigParser {

    GameConfig parse(Reader fileReader) throws IOException, ParseException;
}
