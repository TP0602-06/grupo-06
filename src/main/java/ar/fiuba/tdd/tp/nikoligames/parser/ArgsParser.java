package ar.fiuba.tdd.tp.nikoligames.parser;

import utils.Constants;

/**
 * Responsabilidades:
 * 1.Parsear los argumentos pasados por parametros al programa
 */

public class ArgsParser {

    public static final String DEFAULT_OUTPUT_JSON = "output.json";

    public static final int NUMBER_ARGS_NO_PLAYS = 1;
    public static final int NUMBER_ARGS_WITH_PLAYS = 2;
    public static final int NUMBER_ARGS_WITH_PLAYS_OUTPUT_NAME = 3;

    public static final int ARG_GAME_FILE = 0;
    public static final int ARG_INPUT_PLAYS_FILE = 1;
    public static final int ARG_OUTPUT_PLAYS_FILE = 2;

    private String arg0GameFileName = Constants.CLEAR_STRING;
    private String arg1InputPlaysFileName = Constants.CLEAR_STRING;
    private String arg2OutputPlaysFileName = Constants.CLEAR_STRING;

    public void parseArgs(String[] args) throws Exception {
        if (args.length >= NUMBER_ARGS_NO_PLAYS) {
            this.arg0GameFileName = getString(args, ARG_GAME_FILE);
            if (args.length >= NUMBER_ARGS_WITH_PLAYS) {
                this.arg1InputPlaysFileName = getString(args, ARG_INPUT_PLAYS_FILE);
                if (args.length >= NUMBER_ARGS_WITH_PLAYS_OUTPUT_NAME) {
                    arg2OutputPlaysFileName = getString(args, ARG_OUTPUT_PLAYS_FILE);
                }
            }
        } else {
            throw new Exception("Bad number of arguments ");
        }
    }

    public String getGameFileName() {
        return arg0GameFileName;
    }

    public boolean hasInputPlaysFile() {
        return (!this.arg1InputPlaysFileName.isEmpty());
    }

    public String getInputPlaysFileName() {
        return arg1InputPlaysFileName;
    }

    public String getOutputPlaysFileName() {
        if (hasOutputPlaysFile()) {
            return arg2OutputPlaysFileName;
        }
        return DEFAULT_OUTPUT_JSON;
    }

    private boolean hasOutputPlaysFile() {
        return (!this.arg2OutputPlaysFileName.isEmpty());
    }

    private String getString(String[] args, int number) {
        return (args[number]).toLowerCase();
    }
}
