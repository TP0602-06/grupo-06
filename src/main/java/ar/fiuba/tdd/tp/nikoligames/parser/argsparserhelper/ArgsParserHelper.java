package ar.fiuba.tdd.tp.nikoligames.parser.argsparserhelper;

/**
 * Responsabilidades:
 * 1.Parsear los argumentos pasados por parametros al programa
 */
public class ArgsParserHelper implements AbstractArgsParserHelper {

    public static final int NUMBER_ARGS_NO_PLAYS = 1;
    public static final int NUMBER_ARGS_WITH_PLAYS = 2;

    public static final int ARG_GAME_FILE = 0;
    public static final int ARG_INPUT_PLAYS_FILE = 0;

    private String arg0GameFileName = "";
    private String arg1InputPlaysFileName = "";

    public void parseArgs(String[] args) throws Exception {
        if (args.length >= NUMBER_ARGS_NO_PLAYS) {
            this.arg0GameFileName = getString(args, ARG_GAME_FILE);
            if (args.length >= NUMBER_ARGS_WITH_PLAYS) {
                this.arg1InputPlaysFileName = getString(args, ARG_INPUT_PLAYS_FILE);
            }
        } else {
            throw new Exception("Bad number of arguments ");
        }
    }

    public String getString(String[] args, int number) {
        return (args[number]).toLowerCase();
    }

    public String getGameFileName() {
        return arg0GameFileName;
    }

    public boolean hasInputPlaysFile() {
        return this.arg1InputPlaysFileName.equals("");
    }

    public String getInputPlaysFileName() {
        return arg1InputPlaysFileName;
    }
}
