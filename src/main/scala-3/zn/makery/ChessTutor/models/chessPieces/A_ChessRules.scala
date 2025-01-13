package ChessTutor.models.chessPieces

import ChessTutor.models.Board
import zn.makery.ChessTutor.models.casts.Coordinate

enum Alliance:
  case White, Black

trait Moveable:
  def moves(board: Board, xCoord: Int, yCoord: Int): List[Int]

trait Directional extends Moveable:
  def direction: Int

  override def moves(board: Board, xCoord: Int, yCoord: Int): List[Int] =
    var legalMoves: List[Int] = List()
    board.piece(xCoord + direction, yCoord) match
      case Some(piece) => //do nothing
      case None =>
        legalMoves = legalMoves:+(8*(xCoord+direction)+yCoord)
    legalMoves

trait Traversable extends Moveable: //Any chess piece that can move in all directions
  def directions: List[Coordinate]

  def singleStep: Boolean = false //For ShortTraversals to be true, else false

  /** Scans the board and returns the list of legal moves any Traversable can make
   * Alogrithm requires the directions the piece can go
   *
   * @param board the board the piece is on
   * @param xCoord the xCoordinate on the board
   * @param yCoord the yCoordinate on the board
   * @return the lists of possible moves the piece can make
   */
  override def moves(board: Board, xCoord: Int, yCoord: Int): List[Int] =
    var legalMoves: List[Int] = List()
    for (row, col) <- directions do
      var rowIterable = row + xCoord
      var colIterable = col + yCoord
      while rowIterable >= 0 && rowIterable < 8 && colIterable >= 0 && colIterable < 8 do
        println(s"Possible moves at (${rowIterable}, ${colIterable})")
        board.piece(rowIterable, colIterable) match
          case Some(piece) =>
            if piece.color != this.asInstanceOf[B_ChessPieces].color then
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
    (1, 1), (1, -1),
    (-1, 1), (-1, -1))

trait Crosser extends Traversable:
  override def directions = List(
    (0, 1), (0, -1),
    (1, 0), (-1, 0))

trait AllDirections extends Traversable with Crosser with Diagonal:
  override def directions = super[Diagonal].directions ++ super[Crosser].directions //Combines both directions

trait Octet extends Traversable:
  override def directions = List(
    (2, 1), (2, -1), (1, 2), (1, -2),
    (-1, 2), (-1, -2), (-2, 1), (-2, -1))


  