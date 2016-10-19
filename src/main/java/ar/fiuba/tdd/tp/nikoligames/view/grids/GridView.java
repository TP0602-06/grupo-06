package ar.fiuba.tdd.tp.nikoligames.view.grids;


import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.RegionConfig;

import java.util.List;
import javax.swing.JPanel;


/**
 * Responsabilidades:
 * 1. Crear una abstracción para la vista de grillas
 */
public abstract class GridView extends JPanel {

    public abstract void addCellView(CellView cell);

    public abstract List<CellView> getCellViews();

    public abstract Integer getCols();

    public abstract Integer getRows();

    public abstract void paintRegions(List<RegionConfig> RegionConfig) throws Exception;
}