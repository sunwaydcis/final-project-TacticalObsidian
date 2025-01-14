package ChessTutor.models.chessPieces

import ChessTutor.models.Board
import zn.makery.ChessTutor.models.casts.Coordinate

enum Alliance:
  case White, Black

trait Moveable:
  def moves(board: Board, xCoord: Int, yCoord: Int): List[Int]

trait UniDirectional extends Moveable:
  protected def direction: Int

  override def moves(board: Board, xCoord: Int, yCoord: Int): List[Int] =
    var legalMoves: List[Int] = List()
    if xCoord + direction < 8 && xCoord + direction >= 0 then
      board.pieceOn(xCoord + direction, yCoord) match
        case Some(piece) => //do nothing
        case None =>
          legalMoves = legalMoves:+(8*(xCoord+direction)+yCoord)
    legalMoves

trait PawnTake extends UniDirectional:
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    var moves = super[UniDirectional].moves(board, row, col)
    //Take condition - Standard
    if row + direction >= 0 && row + direction < 8 && col + 1 >= 0 && col + 1 < 8 then
      board.pieceOn(row + direction, col + 1) match
        case Some(piece) =>
          if piece.color != this.asInstanceOf[B_ChessPieces].color then moves = moves :+ ((row + direction) * 8 + col + 1)
        case None =>
    //do nothing

    if row + direction >= 0 && row + direction < 8 && col - 1 >= 0 && col - 1 < 8 then
      board.pieceOn(row + direction, col - 1) match
        case Some(piece) =>
          if piece.color != this.asInstanceOf[B_ChessPieces].color then moves = moves :+ ((row + direction) * 8 + col - 1)
        case None =>
    //do nothing
    moves

trait PawnTwoStep extends UniDirectional:
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    var moves = super[UniDirectional].moves(board, row, col)

    if this.asInstanceOf[B_ChessPieces].totalMoves == 0 then
      board.pieceOn(row + direction, col) match
        case Some(piece) =>
          moves
        case None =>
          board.pieceOn(row + 2 * direction, col) match
            case Some(piece) =>
              moves
            case None =>
              moves = moves :+ ((row + 2 * direction) * 8 + col)
    moves

trait TPawn extends PawnTwoStep, PawnTake:
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    super[PawnTake].moves(board, row, col) ++ super[PawnTwoStep].moves(board, row, col)


trait MultiDirectional extends Moveable: //Any chess piece that can move in all directions
  protected def directions: List[Coordinate]

  protected def singleStep: Boolean = false //For ShortTraversals to be true, else false

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
        board.pieceOn(rowIterable, colIterable) match
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


trait ShortStepper extends MultiDirectional:
  override def singleStep = true

trait Diagonal extends MultiDirectional:
  override def directions = List(
    (1, 1), (1, -1),
    (-1, 1), (-1, -1))

trait Crosser extends MultiDirectional:
  override def directions = List(
    (0, 1), (0, -1),
    (1, 0), (-1, 0))

trait AllDirections extends MultiDirectional with Crosser with Diagonal:
  override def directions = super[Diagonal].directions ++ super[Crosser].directions //Combines both directions

trait Octet extends MultiDirectional:
  override def directions = List(
    (2, 1), (2, -1), (1, 2), (1, -2),
    (-1, 2), (-1, -2), (-2, 1), (-2, -1))


  