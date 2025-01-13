package ChessTutor.models.chessPieces

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.Alliance.*

class King (_color: Alliance) extends A_ChessPieces(_color) with AllDirections with ShortTraversable:

  override val _symbol =
    _color match
      case White => "♔"
      case Black => "♚"
      case _ => throw IllegalArgumentException(s"No such color $_color")


    

