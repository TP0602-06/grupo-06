package ar.fiuba.tdd.tp.nikoligames


import ar.fiuba.tdd.tp.nikoligames.view.View
import ar.fiuba.tdd.tp.nikoligames.view.cells.EditableNumberCell
import ar.fiuba.tdd.tp.nikoligames.view.cells.InvalidCell
import ar.fiuba.tdd.tp.nikoligames.view.cells.NumberCellView
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView

import javax.swing.*

/**
 * Created by mcapolupo on 18/9/16.
 */
object Main {

    @JvmStatic fun main(args: Array<String>) {
        println("Nikolio games :D")
        val vista = View("test", 600, 800)
        val grid = GridOfSquares(7, 10)
        vista.add(grid)
        for (i in 0..6) {
            for (j in 0..9) {
                grid.addCell(InvalidCell())
            }
        }
        vista.isVisible = true
    }
}
