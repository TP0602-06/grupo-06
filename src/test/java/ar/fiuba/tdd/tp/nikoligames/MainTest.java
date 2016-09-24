package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.games.sudoku.SudokuConfigParser;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * Created by mcapolupo on 18/9/16.
 */
public class MainTest {

    @Test
    public void testMain() {

        try {
            FileReader fileReader = new FileReader("./config/games/sudoku/easy.json");
            SudokuConfigParser parser = new SudokuConfigParser();
            GameConfig gameConfig = parser.parse(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
