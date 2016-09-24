package ar.fiuba.tdd.tp.nikoligames.engine.parser.impl;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.games.sudoku.SudokuConfigParser;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by mcapolupo on 24/9/16.
 */

public class SudokuConfigParserTest {

    private final String CONFIG_PATH = "./src/test/config/sudoku/easy.json";

    @Test
    public void testBuildGameConfig() throws FileNotFoundException {

        //Setup
        FileReader fileReader = new FileReader(CONFIG_PATH);
        SudokuConfigParser sudokuConfigParser = new SudokuConfigParser();

        //Call method
        GameConfig gameConfig = sudokuConfigParser.parse(fileReader);

        //Asserts
        assertEquals(new Long(9), gameConfig.getSize().getCols());
        assertEquals(new Long(9), gameConfig.getSize().getRows());
        assertNotNull(gameConfig.getProblem());
        assertNotNull(gameConfig.getSolution());

    }

}
