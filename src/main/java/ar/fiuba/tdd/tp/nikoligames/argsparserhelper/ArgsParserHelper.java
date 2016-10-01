package ar.fiuba.tdd.tp.nikoligames.argsparserhelper;

/**
 * Responsabilidades:
 * 1.Parsear los argumentos pasados por parametros al programa
 */
public class ArgsParserHelper implements AbstractArgsParserHelper {

    public static final int NUMBER_ARGS = 1;
    public static final int ARG_GAME_FILE = 0;

    private String arg0GameFile;

    public void parseArgs(String[] args) throws Exception {
        if (args.length >= NUMBER_ARGS) {
            this.arg0GameFile = (args[ARG_GAME_FILE]).toLowerCase();
        } else {
            throw new Exception("Bad number of arguments ");
        }
    }
    public String getGameFile() {
        return arg0GameFile;
    }
}
