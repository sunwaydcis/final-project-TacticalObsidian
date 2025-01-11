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
      
  override def moves(board: Board, xCoord: Int, yCoord: Int): List[Int] =
    //Two-Step
    var moves = super[Directional].moves(board, xCoord, yCoord)
    if moveStack == 0 then
      moves = moves:+ ((xCoord + direction*2)*8+ yCoord)
    
    //Take condition - Standard
    if board.piece(xCoord + 1, yCoord + 1) == Some then
      moves = moves:+ ((xCoord + 1 + direction*2)*8+ yCoord + 1)
    if board.piece(xCoord + 1, yCoord - 1) == Some then
      moves = moves:+ ((xCoord + 1 + direction*2)*8+ yCoord - 1)
    moves

object Pawn:
  val material: Int = 1


