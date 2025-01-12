package zn.makery.ChessTutor.view

import scalafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints, StackPane}
import scalafx.scene.paint.Color._
import scalafx.scene.shape.{Circle, Rectangle}
import scalafx.scene.text.Text
import ChessTutor.models.Board
import scalafx.scene.input.MouseEvent
import scalafx.Includes._
import ChessTutor.models.chessPieces._

class BoardView(val board: Board) extends GridPane:
  private var selectedPiece: Option[A_ChessPieces] = None
  private var handleCellClick: (Int, Int, StackPane) => Unit = _

  updateBoard()

  def setHandleCellClick(handler: (Int, Int, StackPane) => Unit): Unit =
    handleCellClick = handler

  def initialize(): Unit =
    val cellSize = 50
    // Build the grid view
    (0 until 8).foreach(_ =>
      columnConstraints.add(
        new ColumnConstraints:
          minWidth = cellSize
          prefWidth = cellSize
      )
      rowConstraints.add(
        new RowConstraints:
          minHeight = cellSize
          prefHeight = cellSize
      )
    )

    // Color the cells
    (0 until 8).foreach(row =>
      (0 until 8).foreach(col =>
        val cell = new StackPane()
        val tile = new Rectangle:
          width = cellSize
          height = cellSize
          fill = if (row + col) % 2 == 0 then
            Beige else SaddleBrown

        cell.children.add(tile)
        // Add an event listener using the imported conversion
        cell.onMouseClicked = (event: MouseEvent) => handleCellClick(row, col, cell)
        this.add(cell, col, row)
      )
    )

  def updateBoard(): Unit =
    children.clear()
    initialize()

    (0 until 8).foreach(row =>
      (0 until 8).foreach(col =>
        board.piece(row, col) match
          case Some(piece) =>
            val cell = children.get(row * 8 + col).asInstanceOf[javafx.scene.layout.StackPane]
            val text = new Text(piece._symbol):
              fill = Black
              style = "-fx-font-size: 32px;"
            cell.children.add(text)
          case None =>
      )
    )