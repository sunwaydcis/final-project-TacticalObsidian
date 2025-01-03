package zn.makery.ChessTutor.view

import scalafx.scene.layout.{GridPane, ColumnConstraints, RowConstraints}
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Text
import ChessTutor.models.Board
import ChessTutor.models.chessPieces.A_ChessPieces

class ChessBoardView(board: Board) extends GridPane {

  private val cellSize = 50

  // Set up grid column and row constraints to ensure proper scaling
  for (_ <- 0 until 8) {
    val column = new ColumnConstraints {
      minWidth = cellSize
      prefWidth = cellSize
    }
    this.columnConstraints.add(column)

    val row = new RowConstraints {
      minHeight = cellSize
      prefHeight = cellSize
    }
    this.rowConstraints.add(row)
  }

  // Render Board
  for (row <- 0 until 8) {
    for (col <- 0 until 8) {
      val square = new Rectangle {
        width = cellSize
        height = cellSize
        fill = if ((row + col) % 2 == 0) Beige else Brown
      }
      add(square, col, row)
    }
  }

  // Render Pieces
  def updateBoard(): Unit = {
    children.clear()
    for (row <- 0 until 8) {
      for (col <- 0 until 8) {
        board.piece(row, col) match {
          case Some(piece) =>
            val pieceText = new Text(piece._symbol) {
              fill = Black
              // Optionally, you can add more styling here
            }
            add(pieceText, col, row)
          case None =>
          // Do nothing if there's no piece at this position
        }
      }
    }
  }

  // Call updateBoard to initially render the board and pieces
  updateBoard()
}
