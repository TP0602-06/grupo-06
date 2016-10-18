package ar.fiuba.tdd.tp.nikoligames.parser.argsparserhelper;

/**
 * Responsabilidades:
 * 1.Parsear los argumentos pasados por parametros al programa
 */
public interface AbstractArgsParserHelper {
    void parseArgs(String[] args) throws Exception;

    String getGameFileName();

    String getInputPlaysFileName();

    String getOutputPlaysFileName();

    boolean hasInputPlaysFile();
}
