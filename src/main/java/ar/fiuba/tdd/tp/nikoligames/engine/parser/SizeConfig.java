package ar.fiuba.tdd.tp.nikoligames.engine.parser;


/**
 * Created by mcapolupo on 23/9/16.
 */
public class SizeConfig {
    private Long rows;
    private Long cols;

    public SizeConfig(Long rows, Long cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public Long getCols() {
        return cols;
    }

    public Long getRows() {
        return rows;
    }
}
