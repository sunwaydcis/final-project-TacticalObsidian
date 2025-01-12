package zn.makery.ChessTutor.view

import scalafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints, StackPane}
import scalafx.scene.paint.Color.*
import scalafx.scene.shape.{Circle, Rectangle}
import scalafx.scene.text.Text
import ChessTutor.models.Board
import scalafx.scene.input.MouseEvent
import scalafx.Includes.*
import ChessTutor.models.chessPieces.*
import scalafx.collections.ObservableBuffer
import zn.makery.ChessTutor.util.Evaluator

/**
 * Controls the view of the board. Generates the board view. Violates SRP, TODO seperate responsibilities.
 * @param board the model
 */
class BoardView(board: Board) extends GridPane:
  private var selectedPiece: Option[A_ChessPieces] = None

  updateBoard()

  def initialize(): Unit =
    val cellSize = 50
    //@NameSpace View
    //Build the grid view
    (0 until 8).foreach(_ =>
      columnConstraints.add( //Columns
        new ColumnConstraints:
          minWidth = cellSize
          prefWidth = cellSize

      )
      rowConstraints.add( //Rows
        new RowConstraints:
          minHeight = cellSize
          prefHeight = cellSize
      )
    )

    //Color the cells
    (0 until 8).foreach(row => (0 until 8).foreach(col =>
      val cell = new StackPane()
      val tile = new Rectangle:
          width = cellSize
          height = cellSize
          fill = if (row + col) % 2 == 0 then
            Beige else SaddleBrown

      cell.children.add(tile) //Add the tile to the stack pane
      cell.onMouseClicked = (event: MouseEvent) => handleCellClick(row, col, cell) //Add an event listener to it
      this.add(cell, col, row)  //Add the cell to the grid
      )
    )

  private def updateBoard(): Unit =
    children.clear() //Clear the board
    initialize() //Redraw based on model

    (0 until 8).foreach(row => (0 until 8).foreach(col =>
        board.piece(row, col) match
          case Some(piece) =>
            //Gets the appropriate stack pane
            val cell = children.get(row * 8 + col).asInstanceOf[javafx.scene.layout.StackPane]
            val text = new Text(piece._symbol):
              fill = Black
              style = "-fx-font-size: 32px;"

            cell.children.add(text)
          case None =>
        //Do nothing if no piece
      )
    )

  private def handleCellClick(row: Int, col: Int, cell: StackPane): Unit =
    updateBoard()
    //Utility function of HandleCellClick
    def showMoves(moves: List[Int]): Unit =
      moves.foreach:
        targetTile =>
          val targetCell = children.get(targetTile).asInstanceOf[javafx.scene.layout.StackPane]
          targetCell.children.add(new Circle:
            radius = 5
            fill = Green
          )
          targetCell.onMouseClicked = (event: MouseEvent) =>
            println(s"Target cell at (${targetTile/8}, ${targetTile%8}) clicked!")
            doMove(selectedPiece.get, targetTile/8, targetTile%8)

    //Test line
    println(s"Clicked on cell at ($row, $col)")
    board.piece(row, col) match
      case Some(piece) =>
        println(s"Cell contains piece: ${piece._symbol} ${piece.getClass}")
        selectedPiece = Some(piece)

        //Load all the possible moves a selected piece can make
        val legalMoves = Evaluator.legalMoves(board, piece, row, col)
        showMoves(legalMoves)

      case None =>
        println("Cell is empty")
  end handleCellClick

  private def doMove(piece: A_ChessPieces, newRow: Int, newCol: Int): Unit =
    board.movePiece(piece, newRow, newCol)
    updateBoard() //The board is updated each time.




