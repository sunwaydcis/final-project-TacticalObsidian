package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Bishop (_color: Alliance) extends A_ChessPieces(_color) with Diagonal:
  override val _symbol =
    _color match
      case White => "♗"
      case Black => "♝"
      case _ => throw IllegalArgumentException(s"No such color $_color")

