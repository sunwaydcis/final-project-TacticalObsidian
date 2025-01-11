package ChessTutor.models.chessPieces

import ChessTutor.models.Board

import scala.collection.mutable
import scala.collection.mutable.Stack

enum Alliance:
  case White, Black

abstract class A_ChessPieces(val color: Alliance) extends Moveable:
  val _symbol: String
  val material: Int = 0
  var _moveStack: Stack[(Int, Int)] = Stack.empty //Many pieces require the storing of a moveStack. Will be moved to a trait instead

  def moveStack = _moveStack.size

  def move(newCoordinate: (Int, Int)) =
    _moveStack.push(newCoordinate)
    
//TRAITS

trait Moveable:
  def moves(board: Board, xCoord: Int, yCoord: Int): List[Int]

trait Directional extends Moveable:
  def direction: Int

  override def moves(board: Board, xCoord: Int, yCoord: Int): List[Int] =
    var legalMoves: List[Int] = List()
    board.piece(xCoord+1, yCoord) match
      case Some(piece) =>
        legalMoves.empty
      case None =>
        legalMoves = legalMoves:+(8*(xCoord+direction)+yCoord)
    legalMoves
    

trait Traversable extends Moveable: //Any chess piece that can move in all directions
  def directions: List[(Int, Int)]

  def singleStep: Boolean = false //For ShortTraversals to be true, else false

  //Traversable move by default is a Long Traversable
  override def moves(board: Board, xCoord: Int, yCoord: Int): List[Int] =
    var legalMoves: List[Int] = List()
    for (row, col) <- directions do
      var rowIterable = row + xCoord
      var colIterable = col + yCoord
      while rowIterable >= 0 && rowIterable < 8 && colIterable >= 0 && colIterable < 8 do
        println(s"Possible moves at (${rowIterable}, ${colIterable})")
        board.piece(rowIterable, colIterable) match
          case Some(piece) =>
            if piece.color != this.asInstanceOf[A_ChessPieces].color then
              legalMoves = legalMoves :+ (rowIterable * 8 + colIterable)
            rowIterable = -1
            colIterable = -1
          case None =>
            legalMoves = legalMoves :+ (rowIterable * 8 + colIterable)
        if singleStep then
          rowIterable = -1
          colIterable = -1

        if rowIterable != -1 && colIterable != -1 then
          rowIterable += row
          colIterable += col
    legalMoves
    

trait ShortTraversable extends Traversable:
  override def singleStep = true


trait Diagonal extends Traversable:
  override def directions = List(
    (1, 1),
    (1, -1),
    (-1, 1),
    (-1, -1)
  )

trait Crosser extends Traversable:
  override def directions = List(
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
  )

trait AllDirections extends Traversable with Crosser with Diagonal:
  override def directions =
    super[Diagonal].directions ++ super[Crosser].directions

trait Octet extends Traversable:
  override def directions = List(
    (2, 1),
    (2, -1),
    (1, 2),
    (1, -2),
    (-1, 2),
    (-1, -2),
    (-2, 1),
    (-2, -1)
  )


  