package ar.fiuba.tdd.tp.nikoligames.view.hints;

/**
 * Created by fedebrasburg on 10/17/16.
 */
public enum HintPainterEnum {
    @SuppressWarnings("CPD-START")
    KAKURO() {
        public HintPainter createCell(String numbers) {
            return new KakuroPainter(numbers);
        }
    }, NULLCELL() {
        public HintPainter createCell(String empty) {
            return new NullPainter();
        }
    }, CONTENTCELL() {
        public HintPainter createCell(String number) {
            return new ContentPainter(number);
        }
    }, INSHYCELL() {
        public HintPainter createCell(String number) {
            return new InshiPainter(number);
        }
    },
    SLITHERCELL() {
        public HintPainter createCell(String empty) {
            return new SlitherPainter();
        }
    },
    GOKIGENCELL() {
        public HintPainter createCell(String number) {
            return new GokigenHintPainter(number);
        }
    };
    @SuppressWarnings("CPD-END")

    public static HintPainterEnum getCellHint(String cellType) throws NotValidCellHintException {
        for (HintPainterEnum cellHint : HintPainterEnum.values()) {
            if (cellHint.isCell(cellType)) {
                return cellHint;
            }
        }
        throw new NotValidCellHintException();
    }

    public boolean isCell(String string) {
        return this.toString().equals(string);
    }

    public abstract HintPainter createCell(String content);


}
