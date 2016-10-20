package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.RegionConfig;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Responsabilidades:
 * 1. Crear una abstracción para la encapsulación de la creación de una grilla para el tablero o board
 * Patrón:
 * 1. Abstract Factory
 */
public interface FactoryBoard {

    GridView createGridView(boolean nodeMatchesCell, List<RegionConfig> regionConfigs) throws Exception;

    void addInputs(GameView view, Set<String> inputs);

}
