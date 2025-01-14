package ChessTutor.models.chessPieces

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.Alliance.*
import zn.makery.ChessTutor.models.casts.Coordinate

enum Alliance:
  case White, Black

trait Moveable:
  def moves(board: Board, row: Int, col: Int): List[Int]

trait Directional extends Moveable:
  def direction: Int =
    this.asInstanceOf[BaseChessPiece].color match
      case White => -1
      case Black => 1

  override def moves(board: Board, row: Int, col: Int): List[Int] =
    var legalMoves: List[Int] = List()
    board.piece(row + direction, col) match
      case Some(piece) => //do nothing
      case None =>
        legalMoves = legalMoves:+(8*(row+direction)+col)
    legalMoves

trait PawnTake extends Directional:
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    var moves = super[Directional].moves(board, row, col)
    //Take condition - Standard
    if row + direction >= 0 && row + direction < 8 && col + 1 >= 0 && col + 1 < 8 then
      board.piece(row + direction, col + 1) match
        case Some(piece) =>
          if piece.color != this.asInstanceOf[BaseChessPiece].color then moves = moves :+ ((row + direction) * 8 + col + 1)
        case None =>
    //do nothing

    if row + direction >= 0 && row + direction < 8 && col - 1 >= 0 && col - 1 < 8 then
      board.piece(row + direction, col - 1) match
        case Some(piece) =>
          if piece.color != this.asInstanceOf[BaseChessPiece].color then moves = moves :+ ((row + direction) * 8 + col - 1)
        case None =>
    //do nothing
    moves

trait PawnTwoStep extends Directional:
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    var moves = super[Directional].moves(board, row, col)

    if this.asInstanceOf[BaseChessPiece].moveStack == 0 then
      board.piece(row + direction, col) match
        case Some(piece) =>
          moves
        case None =>
          board.piece(row + 2 * direction, col) match
            case Some(piece) =>
              moves
            case None =>
              moves = moves :+ ((row + 2 * direction) * 8 + col)
    moves

trait TPawn extends PawnTwoStep, PawnTake:
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    super[PawnTake].moves(board, row, col) ++ super[PawnTwoStep].moves(board, row, col)



trait Traversable extends Moveable: //Any chess piece that can move in all directions
  def directions: List[Coordinate]

  def singleStep: Boolean = false //For ShortTraversals to be true, else false

  /** Scans the board and returns the list of legal moves any Traversable can make
   * Alogrithm requires the directions the piece can go
   *
   * @param board the board the piece is on
   * @param row the xinate on the board
   * @param col the yinate on the board
   * @return the lists of possible moves the piece can make
   */
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    var legalMoves: List[Int] = List()
    for (row, col) <- directions do
      var rowIterable = row + row
      var colIterable = col + col
      while rowIterable >= 0 && rowIterable < 8 && colIterable >= 0 && colIterable < 8 do
        println(s"Possible moves at (${rowIterable}, ${colIterable})")
        board.piece(rowIterable, colIterable) match
          case Some(piece) =>
            if piece.color != this.asInstanceOf[BaseChessPiece].color then
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
  def directions = List(
    (1, 1), (1, -1),
    (-1, 1), (-1, -1))

trait Crosser extends Traversable:
  def directions = List(
    (0, 1), (0, -1),
    (1, 0), (-1, 0))

trait AllDirections extends Traversable with Crosser with Diagonal:
  override def directions = super[Diagonal].directions ++ super[Crosser].directions //Combines both directions

trait Octet extends Traversable:
  def directions = List(
    (2, 1), (2, -1), (1, 2), (1, -2),
    (-1, 2), (-1, -2), (-2, 1), (-2, -1))


  