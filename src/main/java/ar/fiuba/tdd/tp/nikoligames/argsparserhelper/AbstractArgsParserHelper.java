package ar.fiuba.tdd.tp.nikoligames.argsparserhelper;

/**
 * Responsabilidades:
 * 1.Parsear los argumentos pasados por parametros al programa
 */
public interface AbstractArgsParserHelper {
    void parseArgs(String[] args) throws Exception;

    String getArgGameType();

    String getArgGameConfigFile();
}
