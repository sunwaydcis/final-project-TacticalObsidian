package zn.makery.ChessTutor.view

import scalafx.scene.layout.{GridPane, ColumnConstraints, RowConstraints}
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Text
import ChessTutor.models.Board
import ChessTutor.models.chessPieces.A_ChessPieces

class BoardView(board: Board) extends GridPane:
  updateBoard()

  def initialize() =
    val cellSize = 50
    //Build the grid view
    (0 until 8).foreach(_ =>
      //Columns
      columnConstraints.add(
        new ColumnConstraints{
          minWidth = cellSize
          prefWidth = cellSize
        }
      )
      //Rows
      rowConstraints.add(
        new RowConstraints {
          minHeight = cellSize
          prefHeight = cellSize
        }
      )
    )

    //Color the cells
    (0 until 8).foreach(row =>
      (0 until 8).foreach(col =>
        val cell = new Rectangle {
          width = cellSize
          height = cellSize
          fill = if (row + col) % 2 == 0 then
            Beige else SaddleBrown
        }

        //Add the rectangle (colored cell) to the gridPane
        this.add(cell, col, row)
      )
    )

  def updateBoard(): Unit =
    children.clear() //Clear the board
    initialize() //Redraw

    (0 until 8).foreach(row =>
      (0 until 8).foreach(col =>
        board.piece(row, col) match
          case Some(piece) =>
            add(new Text(piece._symbol) {fill = Black},
              col, row)

          case None =>
        //Do nothing if no piece
      )
    )


