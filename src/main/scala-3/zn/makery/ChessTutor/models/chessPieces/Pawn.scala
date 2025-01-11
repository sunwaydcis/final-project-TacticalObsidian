package ChessTutor.models.chessPieces

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.Alliance.*

class Pawn (_color: Alliance) extends A_ChessPieces(_color) with Directional:
  override def direction : Int =
    this._color match
    case White => -1
    case Black => 1
  
  override val _symbol =
    _color match
      case White => "♙"
      case Black => "♟"
      case _ => throw IllegalArgumentException(s"No such color $_color")
      
  override def moves(board: Board, yCoord: Int, xCoord: Int): List[Int] =
    //Two-Step
    var moves = super[Directional].moves(board, yCoord, xCoord)
    if moveStack == 0 then
      moves = moves:+ ((yCoord + direction*2)*8+ xCoord)
    
    //Take condition - Standard
    if board.piece(yCoord + 1, xCoord + 1) == Some then
      moves = moves:+ ((yCoord + 1 + direction*2)*8+ xCoord + 1)
    if board.piece(yCoord + 1, xCoord - 1) == Some then
      moves = moves:+ ((yCoord + 1 + direction*2)*8+ xCoord - 1)
    moves

object Pawn:
  val material: Int = 1


