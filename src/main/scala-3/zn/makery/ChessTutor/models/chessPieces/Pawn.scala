package ChessTutor.models.chessPieces

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.Alliance.*

class Pawn (_color: Alliance) extends B_ChessPieces(_color) with Directional:

  override def direction : Int =
    this._color match
    case White => -1
    case Black => 1
  
  override val _symbol: String =
    _color match
      case White => "♙"
      case Black => "♟"
      case null => throw IllegalArgumentException(s"No such color $_color")
      
  override def moves(board: Board, xCoord: Int, yCoord: Int): List[Int] =
    //Two-Step
    var moves = super[Directional].moves(board, xCoord, yCoord)
    if moveStack == 0 then
      board.piece(xCoord + direction, yCoord) match
        case Some(piece) =>
            moves
        case None =>
          board.piece(xCoord + 2*direction, yCoord) match
            case Some(piece) =>
              moves
            case None =>
              moves = moves :+ ((xCoord + 2 * direction) * 8 + yCoord)
    
    //Take condition - Standard
    if xCoord + direction >=0 && xCoord + direction < 8 && yCoord + 1 >= 0 && yCoord + 1 < 8 then
      board.piece(xCoord + direction, yCoord + 1) match
      case Some(piece) =>
        if piece.color != this._color then moves = moves:+ ((xCoord + direction)*8+ yCoord + 1)
      case None =>
        //do nothing

    if xCoord + direction >=0 && xCoord + direction < 8 && yCoord - 1 >= 0 && yCoord - 1 < 8 then
    board.piece(xCoord + direction, yCoord - 1) match
      case Some(piece) =>
        if piece.color != this._color then moves = moves:+ ((xCoord + direction)*8+ yCoord - 1)
      case None =>
        //do nothing
    moves


