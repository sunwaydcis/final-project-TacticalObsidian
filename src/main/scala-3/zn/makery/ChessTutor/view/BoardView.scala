package zn.makery.ChessTutor.view

import scalafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints, StackPane}
import scalafx.scene.paint.Color.*
import scalafx.scene.shape.{Circle, Rectangle}
import scalafx.scene.text.Text
import scalafx.scene.input.MouseEvent
import scalafx.Includes.*
import ChessTutor.models.chessPieces.*
import scalafx.collections.ObservableBuffer
import zn.makery.ChessTutor.LongLiveTheKingApp
import zn.makery.ChessTutor.models.{Game, Moves}


/**
 * A graphical representation of the chess game board. This class is responsible for displaying the board,
 * managing user interactions, and updating the view based on the game's state. It extends `GridPane`
 * to create a grid layout for the chessboard.
 *
 * The board is an 8x8 grid where cells are either beige or saddle brown. Chess pieces, their movement,
 * and updates to the board's state are displayed dynamically.
 *
 * @constructor Creates an instance of the `BoardView` with a reference to the `Game` model.
 * @param game The game model providing the state of the board and pieces.
 */
class BoardView(private val game: Game) extends GridPane: //This approach is highly unorthodox to practicals 4-7, but tries to follow MySecondGui
  private var selectedPiece: Option[ChessPiece] = None
  private val board = game.board
  private var passiveMoves = 0
  updateBoard()

  private def initialize(): Unit =
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

  /**
   * Updates the chessboard UI to reflect the current state of the board model.
   * Clears the existing board UI and repopulates it with pieces at their current position on the model
   * For each row and column, if a piece exists in the model at the corresponding position,
   * it will add the appropriate graphical representation (text symbol) to the UI.
   *
   * @return Unit
   */
  private def updateBoard(): Unit =
    children.clear() //Clear the board
    initialize() //Redraw based on model

    (0 until 8).foreach(row => (0 until 8).foreach(col =>
        board.pieceAt(row, col) match
          case Some(piece) =>
            //Gets the appropriate stack pane
            val cell = children.get(row * 8 + col).asInstanceOf[javafx.scene.layout.StackPane]
            val text = new Text(piece.symbol):
              fill = Black
              style = "-fx-font-size: 32px;"

            cell.children.add(text)
          case None =>
        //Do nothing if no piece
      )
    )

  /**
   * Highlights the possible passiveMoves of a selected piece on the game board and sets up a click event for each target cell.
   *
   * @param passiveMoves A list of integers representing the indices of the target cells where the selected piece can move.
   * @return Nothing is returned as the method has a Unit return type. The method modifies the UI to display the passiveMoves and attaches click handlers to the target cells.
   */
  private def showMoves(moves: List[Int]): Unit =
    moves.foreach:
      targetTile =>
        val targetCell = children.get(targetTile).asInstanceOf[javafx.scene.layout.StackPane]
        targetCell.children.add(new Circle:
          radius = 5
          fill = Green
        )
        targetCell.onMouseClicked = (event: MouseEvent) =>
          println(s"Target cell at (${targetTile / 8}, ${targetTile % 8}) clicked!")
          doMove(selectedPiece.get, targetTile / 8, targetTile % 8)

  /**
   * Handles the click event on a specific cell in the grid. This method determines the presence
   * of a piece at the given cell location, updates the board accordingly, and optionally displays
   * possible passiveMoves for a selected piece.
   *
   * @param row  The row index of the cell that was clicked.
   * @param col  The column index of the cell that was clicked.
   * @param cell The scalaFX Layout containing the piece and respective bkg
   * @return Unit This method does not return a value. It listens to user clicks and deals with them.
   */
  private def handleCellClick(row: Int, col: Int, cell: StackPane): Unit =
    updateBoard()
    //Utility function of HandleCellClick
//    //Test line
//    println(s"Clicked on cell at ($row, $col)")
    board.pieceAt(row, col) match
      case Some(piece) =>
        selectedPiece = Some(piece)
//        println(s"Cell contains piece: ${piece._symbol} ${piece.getClass}")
          showMoves(piece.moves(board, row, col))
      case None =>  //Do nothing
  end handleCellClick

  /**
   * Executes a move for a given chess piece to a new position on the board.
   * Updates the board to reflect the move, checks for win conditions, and logs the move.
   *
   * @param piece  the chess piece to be moved
   * @param newRow the target row to which the piece will be moved
   * @param newCol the target column to which the piece will be moved
   * @return Unit, this method does not produce a return value
   *
   * @note Every move made, the board is scanned to see if a win or draw condition has been met.
   *       Else, it'll create a new instance of `Move` to be stored onto the `MoveHistoryTable > GameViewController`
   */
  //Moves the piece from the board
  private def doMove(piece: ChessPiece, newRow: Int, newCol: Int): Unit =
    loadNewMove(piece, newRow, newCol)
    isDraw()
    kingDead(piece, newRow, newCol)
    board.movePiece(piece, newRow, newCol)
    updateBoard() //The board is updated each time.

  private def loadNewMove(piece: ChessPiece, newRow: Int, newCol: Int): Unit =
    //Returns a letter for correspondent board column
    val column = newCol match
      case 0 => "A"
      case 1 => "B"
      case 2 => "C"
      case 3 => "D"
      case 4 => "E"
      case 5 => "F"
      case 6 => "G"
      case 7 => "H"

    //Returns chess correct position (Example: (0, 7) => h1
    val newPosition = String.format(s"$column$newRow")

    val takes =
      board.pieceAt(newRow, newCol) match
        case Some(piece) =>
          passiveMoves = 0
          Some(piece)
        case None =>
          passiveMoves += 1
          None
    game.moves += Moves(piece, newPosition, takes)

  private def kingDead(piece: ChessPiece, newRow: Int, newCol: Int): Unit =
    //Checks if the opposing king has been taken for win condition
    val opposingKingColor = piece.color match
      case Alliance.White => Alliance.Black
      case Alliance.Black => Alliance.White

    // Find the position of the opposing king
    val opposingKingPosition = board.piecePositions.find {
      case (p, _) => p.isInstanceOf[King] && p.color == opposingKingColor
    }.map(_._2)

    opposingKingPosition match
      case Some((kingRow, kingCol)) =>
        val end = opposingKingPosition.get
        if end == (newRow, newCol) then
          val (winner) = piece.color match
            case Alliance.White => (game.whiteName, Alliance.White)
            case Alliance.Black => (game.blackName, Alliance.Black)
          LongLiveTheKingApp.winDialog(s"${winner._1} Won!", Some(winner._2))
      case None =>

  private def isDraw(): Unit =
    if (passiveMoves >= 5) //Normally 50 move rule, but since the game is about taking the king with as little rules as possible, add a stricter condition.
      LongLiveTheKingApp.winDialog("Draw", None)
