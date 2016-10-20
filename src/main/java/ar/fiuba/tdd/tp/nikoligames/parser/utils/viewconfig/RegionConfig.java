package ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.Region;

import java.util.List;

/**
 * Created by tobias on 19/10/16.
 */
public class RegionConfig {
    private Region regin;

    public RegionConfig(List<Position> positions) {
        regin = new Region(positions);
    }

    public Region getRegion() {
        return regin;
    }
}
