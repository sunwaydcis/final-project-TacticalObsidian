package ChessTutor.models.chessPieces //much faster to import

import ChessTutor.models.Board
import zn.makery.ChessTutor.models.casts.Coordinate

//Type safe means to assign color.
enum Alliance:
  case White, Black

/**
 * @note Final commit: Removing of all warnings by adding _:List[Coordinate] (aside from `ChessTutor.models... not correspond...`) 
 */


//All pieces can make a move
trait Moveable:
  def moves(board: Board, row: Int, col: Int): List[Int]

//Only pieces that can move 1 direction
trait UniDirectional extends Moveable:
  protected def direction: Int
  
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    var legalMoves: List[Int] = List()
    if row + direction < 8 && row + direction >= 0 then
      board.pieceAt(row + direction, col) match
        case Some(piece) => //do nothing
        case None =>
          legalMoves = legalMoves:+(8*(row+direction)+col)
    legalMoves

/**
 * @note Pawns are the only Unidirectional class, Unidirectional was used as it's more meaningful to store it that way
 * @note Pawn takes scan left and right forward.
 */
trait PawnTake extends UniDirectional:
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    var moves = super[UniDirectional].moves(board, row, col)
    //Take condition - Standard
    if row + direction >= 0 && row + direction < 8 && col + 1 >= 0 && col + 1 < 8 then
      board.pieceAt(row + direction, col + 1) match
        case Some(piece) =>
          if piece.color != this.asInstanceOf[ChessPiece].color then moves = moves :+ ((row + direction) * 8 + col + 1)
        case None =>
    //do nothing

    if row + direction >= 0 && row + direction < 8 && col - 1 >= 0 && col - 1 < 8 then
      board.pieceAt(row + direction, col - 1) match
        case Some(piece) =>
          if piece.color != this.asInstanceOf[ChessPiece].color then moves = moves :+ ((row + direction) * 8 + col - 1)
        case None =>
    //do nothing
    moves

/**
 * again, only pawns can make 2 moves at the start.
 * But this is immediately stopped if in front of them is a piece (by at least 1 or 2 tiles ahead of them)
 */
trait PawnTwoStep extends UniDirectional:
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    var moves = super[UniDirectional].moves(board, row, col)

    if this.asInstanceOf[ChessPiece].totalMoves == 0 then
      board.pieceAt(row + direction, col) match
        case Some(piece) => //Do nothing
        case None =>
          board.pieceAt(row + 2 * direction, col) match
            case Some(piece) => //Do nothing
            case None =>
              moves = moves :+ ((row + 2 * direction) * 8 + col)
    moves

//Combined both behaviours. Allowed for better combination of move rules.
trait TPawn extends PawnTwoStep, PawnTake:
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    super[PawnTake].moves(board, row, col) ++ super[PawnTwoStep].moves(board, row, col)

//Applies to all non pawn pieces since they can go in multiple directions
trait MultiDirectional extends Moveable:
  protected def directions: List[Coordinate]

  //For King, Knight since they one tile in each direction
  protected def singleStep: Boolean = false

  /** Scans the board from the piece's current position across its directions
   * and returns the list of legal moves any MultiDirectional can make
   * Algorithm requires the directions the piece can go
   * 
   * @param board the board the piece is on
   * @param row the xCoordinate on the board
   * @param col the yCoordinate on the board
   * @return the lists of possible move the piece can make
   *         
   * @note Yes it's very verbose :(
   */
  override def moves(board: Board, row: Int, col: Int): List[Int] =
    var legalMoves: List[Int] = List()
    for (directionalRow, directionalCol) <- directions do
      var rowIterable = row + directionalRow
      var colIterable = col + directionalCol
      while rowIterable >= 0 && rowIterable < 8 && colIterable >= 0 && colIterable < 8 do
        println(s"Possible moves at ($rowIterable, $colIterable)")
        board.pieceAt(rowIterable, colIterable) match
          case Some(piece) =>
            if piece.color != this.asInstanceOf[ChessPiece].color then
              legalMoves = legalMoves :+ (rowIterable * 8 + colIterable)
            rowIterable = -1
            colIterable = -1
          case None => legalMoves = legalMoves :+ (rowIterable * 8 + colIterable)
          
        if singleStep then //stop the loop
          rowIterable = -1
          colIterable = -1

        if rowIterable != -1 && colIterable != -1 then
          rowIterable += row
          colIterable += col
    legalMoves

//These are directions and helper variables for MultiDirectional
trait ShortStepper extends MultiDirectional:
  override def singleStep = true

trait Diagonal extends MultiDirectional:
  override def directions: List[Coordinate] = List(
    (1, 1), (1, -1),
    (-1, 1), (-1, -1))

trait Crosser extends MultiDirectional:
  override def directions: List[Coordinate] = List(
    (0, 1), (0, -1),
    (1, 0), (-1, 0))

trait AllDirections extends MultiDirectional with Crosser with Diagonal:
  override def directions: List[Coordinate] = super[Diagonal].directions ++ super[Crosser].directions //Combines both directions

trait Octet extends MultiDirectional:
  override def directions: List[Coordinate] = List(
    (2, 1), (2, -1), (1, 2), (1, -2),
    (-1, 2), (-1, -2), (-2, 1), (-2, -1))


  