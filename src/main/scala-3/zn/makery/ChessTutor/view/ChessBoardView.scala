package zn.makery.ChessTutor.view

import scalafx.scene.layout.GridPane
import scalafx.scene.shape.Rectangle
import scalafx.scene.paint.Color
import scalafx.scene.text.Text
import ChessTutor.models.Board
import ChessTutor.models.chessPieces.A_ChessPieces

class ChessBoardView(board: Board) extends GridPane:

  private val cellSize = 60

  // Render Board
  for row <- 0 until 8 do
    for col <- 0 until 8 do
      val square = new Rectangle:
        width = cellSize
        height = cellSize
        fill = if ((row + col) % 2 == 0) Color.BEIGE else Color.BROWN

      add(square, col, row)

  // Render Pieces
  def updateBoard(): Unit =
    children.clear()
    for row <- 0 until 8 do
      for col <- 0 until 8 do
        board.piece(row, col) match
          case Some(piece) =>
            val pieceText = new Text(piece._symbol)
            add(pieceText, col, row)
          case None =>

  updateBoard()
