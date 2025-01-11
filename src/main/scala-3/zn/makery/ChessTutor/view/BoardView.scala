package zn.makery.ChessTutor.view

import scalafx.scene.layout.{ColumnConstraints, GridPane, RowConstraints, StackPane}
import scalafx.scene.paint.Color.*
import scalafx.scene.shape.{Circle, Rectangle}
import scalafx.scene.text.Text
import ChessTutor.models.Board
import scalafx.scene.input.MouseEvent
import scalafx.Includes.*
import ChessTutor.models.chessPieces.{Alliance, *}
import zn.makery.ChessTutor.util.Evaluator

class BoardView(board: Board) extends GridPane:
  var selectedPiece: Option[A_ChessPieces] = None


  updateBoard()

  def initialize() =
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

  private def handleClickMove(row: Int, col: Int, cell: StackPane): Unit =
    board.piece(row, col) match
      case Some(piece) =>
        val selectedPiece = Some(piece)


  private def handleCellClick(row: Int, col: Int, cell: StackPane): Unit =
    //Utility function of HandleCellClick
    def showMoves(moves: List[Int]): Unit =
      moves.foreach:
        case targetTile =>
          val targetCell = children.get(targetTile).asInstanceOf[javafx.scene.layout.StackPane]
          targetCell.children.add(new Circle:
            radius = 5
            fill = Green
          )

    //Test line
    println(s"Clicked on cell at ($row, $col)")
    board.piece(row, col) match
      case Some(piece) =>
        println(s"Cell contains piece: ${piece._symbol} ${piece.getClass}")
        selectedPiece = Some(piece)

        //Load all the possible moves a selected piece can make
        val legalMoves = Evaluator.legalMoves(piece, row, col)
        showMoves(legalMoves)

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
            
      case None =>
        println("Cell is empty")


