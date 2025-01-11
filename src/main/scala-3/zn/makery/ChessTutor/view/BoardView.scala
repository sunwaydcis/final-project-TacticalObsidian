package zn.makery.ChessTutor.view

import scalafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints, StackPane}
import scalafx.scene.paint.Color.*
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Text
import ChessTutor.models.Board
import scalafx.scene.input.MouseEvent
import scalafx.Includes.*
import ChessTutor.models.chessPieces._

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
        val cell = new StackPane()
        val tile = new Rectangle {
          width = cellSize
          height = cellSize
          fill = if (row + col) % 2 == 0 then
            Beige else SaddleBrown
        }
        cell.children.add(tile)
        cell.onMouseClicked = (event: MouseEvent) => handleCellClick(row, col, cell)
        //Add the cell to the grid
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

  private def handleCellClick(row: Int, col: Int, cell: StackPane): Unit =
    //Test line
    println(s"Clicked on cell at ($row, $col)")
    board.piece(row, col) match
      case Some(piece) =>
        println(s"Cell contains piece: ${piece._symbol} ${piece.getClass}")
        
        piece match
          case _: Pawn =>
            println("Its a Pawn!")
            if piece.moveStack = 0 then
              println()
            
          case _: Rook =>
            println("It's a Rook!")
          case _ =>
            println("Ooo me don't know!")
            
      case None =>
        println("Cell is empty")


