package ar.fiuba.tdd.tp.nikoligames.parser.utils;


/**
 * Created by mcapolupo on 23/9/16.
 */
public class SizeConfig {
    private Integer rows;
    private Integer cols;

    public SizeConfig(Integer rows, Integer cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public Integer getCols() {
        return cols;
    }

    public Integer getRows() {
        return rows;
    }
}
