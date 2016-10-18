package ar.fiuba.tdd.tp.nikoligames.view.cells;

/**
 * Created by fedebrasburg on 10/17/16.
 */
public enum CellHintEnum {
    KAKURO() {
        public CellHint createCell(String numbers) {
            return new KakuroCell(numbers);
        }
    }, NULLCELL() {
        public CellHint createCell(String empty) {
            return new NullCell();
        }
    }, CONTENTCELL() {
        public CellHint createCell(String number) {
            return new ContentCell(number);
        }
    }, INSHYCELL() {
        public CellHint createCell(String number) {
            return new InshiCell(number);
        }
    };

    public static CellHintEnum getCellHint(String cellType) throws NotValidCellHintException {
        for (CellHintEnum cellHint : CellHintEnum.values()) {
            if (cellHint.isCell(cellType)) {
                return cellHint;
            }
        }
        throw new NotValidCellHintException();
    }

    public boolean isCell(String string) {
        return this.toString().equals(string);
    }

    public abstract CellHint createCell(String content);


}
