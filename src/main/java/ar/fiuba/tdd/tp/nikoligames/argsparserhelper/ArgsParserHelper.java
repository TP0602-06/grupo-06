package ar.fiuba.tdd.tp.nikoligames.argsparserhelper;

/**
 * Responsabilidades:
 * 1.Parsear los argumentos pasados por parametros al programa
 */
public class ArgsParserHelper implements AbstractArgsParserHelper {

    public static final int NUMBER_ARGS = 2;
    public static final int ARG_GAME_TYPE = 0;
    public static final int ARG_GAME_DIFFICULTY = 1;

    private String arg0GameType;
    private String arg1GameDifficulty;

    public void parseArgs(String[] args) throws Exception {
        if (args.length == NUMBER_ARGS) {
            this.arg0GameType = (args[ARG_GAME_TYPE]).toLowerCase();
            this.arg1GameDifficulty = args[ARG_GAME_DIFFICULTY];
        } else {
            throw new Exception("Bad number of arguments, - Example: 'sudoku' 'easy' ");
        }
    }

    public String getArgGameType() {
        return arg0GameType;
    }

    public String getArgGameDifficulty() {
        return arg1GameDifficulty;
    }
}
