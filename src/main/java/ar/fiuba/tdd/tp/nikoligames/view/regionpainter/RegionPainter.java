package ar.fiuba.tdd.tp.nikoligames.view.regionpainter;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.RegionConfig;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.painters.bordercell.BorderCellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tobias on 19/10/16.
 */
public class RegionPainter {
    private List<Region> regions;
    private BorderCellPainter topBorderPainter;
    private BorderCellPainter bottomBorderPainter;
    private BorderCellPainter leftBorderPainter;
    private BorderCellPainter righBorderPainter;

    public RegionPainter(List<RegionConfig> regionConfigs) {
        regions = filterRegionRules(regionConfigs);
        Integer bold = PainterBuilder.BOLD;
        topBorderPainter = new BorderCellPainter(bold,PainterBuilder.TOP);
        bottomBorderPainter = new BorderCellPainter(bold,PainterBuilder.BOTTOM);
        leftBorderPainter = new BorderCellPainter(bold,PainterBuilder.LEFT);
        righBorderPainter = new BorderCellPainter(bold,PainterBuilder.RIGHT);
    }

    private List<Region> filterRegionRules(List<RegionConfig> regionConfigs) {
        List<Region> regions = new ArrayList<>();
        Iterator ruleIterator = regionConfigs.iterator();
        while (ruleIterator.hasNext()) {
            RegionConfig regionConfig = (RegionConfig) ruleIterator.next();
            regions.add(regionConfig.getRegion());
        }
        return regions;
    }

    public void addBorders(List<CellView> cellViews) throws Exception {
        Iterator<Region> regionIterator = regions.iterator();
        while (regionIterator.hasNext()) {
            Region region = regionIterator.next();
            paintCells(region.getTopCells(cellViews),topBorderPainter);
            paintCells(region.getBottomCells(cellViews),bottomBorderPainter);
            paintCells(region.getLeftCells(cellViews),leftBorderPainter);
            paintCells(region.getRightCells(cellViews),righBorderPainter);
        }
    }

    private void paintCells(List<CellView> cellViews, BorderCellPainter borderPainter) {
        Iterator<CellView> cellViewIterator = cellViews.iterator();
        while ( cellViewIterator.hasNext() ) {
            CellView cell = cellViewIterator.next();
            borderPainter.paintCell(cell);
        }
    }
}
