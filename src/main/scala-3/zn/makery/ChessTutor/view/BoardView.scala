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

class BoardView(board: Board) extends GridPane:
  val evaluator = new Evaluator(board)
  private var selectedPiece: Option[A_ChessPieces] = None


  updateBoard()

  def initialize(): Unit =
    val cellSize = 50
    //@NameSpace View
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

  private def updateBoard(): Unit =
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
        val legalMoves = evaluator.legalMoves(piece, row, col)
        showMoves(legalMoves)

      case None =>
        println("Cell is empty")
  end handleCellClick

  private def doMove(piece: A_ChessPieces, newRow: Int, newCol: Int): Unit =
    board.movePiece(piece, newRow, newCol)
    updateBoard() //The board is updated each time.

//        piece match
//          case _: Pawn =>
//            println("Its a Pawn!")
//                println("It hasn't moved yet")
//                if piece.color == Alliance.White then
//                  val targetCell1 = children.get((row - 1)*8 + col).asInstanceOf[javafx.scene.layout.StackPane]
//
//                  targetCell1.children.add(new Circle{
//                    radius = 5
//                    fill = Green
//                  })
//
//                  if piece.moveStack == 0 then
//                    val targetCell2 = children.get((row - 2)*8 + col).asInstanceOf[javafx.scene.layout.StackPane]
//                    targetCell2.children.add(new Circle{
//                      radius = 5
//                      fill = Green
//                    })
//
//
//                else
//                  val targetCell1 = children.get((row + 1)*8 + col).asInstanceOf[javafx.scene.layout.StackPane]
//                  targetCell1.children.add(new Circle{
//                    radius = 5
//                    fill = Green
//                  })
//
//                  if piece.moveStack == 0 then
//                    val targetCell2 = children.get((row - 2)*8 + col).asInstanceOf[javafx.scene.layout.StackPane]
//                    targetCell2.children.add(new Circle{
//                      radius = 5
//                      fill = Green
//                    })
//
//
//          case _: Rook =>
//            println("It's a Rook!")
//          case _ =>
//            println("Ooo me don't know!")



