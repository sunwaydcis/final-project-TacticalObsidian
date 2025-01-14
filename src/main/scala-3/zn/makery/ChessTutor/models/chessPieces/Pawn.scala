package ChessTutor.models.chessPieces

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.Alliance.*

class Pawn (_color: Alliance) extends B_ChessPieces(_color) with TPawn:

  override def direction : Int =
    this._color match
    case White => -1
    case Black => 1
  
  override val _symbol: String =
    _color match
      case White => "♙"
      case Black => "♟"
      case null => throw IllegalArgumentException(s"No such color $_color")


