package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Bishop (__color: Alliance) extends B_ChessPieces(__color) with Diagonal:
  override val _symbol =
    __color match
      case White => "♗"
      case Black => "♝"
      case _ => throw IllegalArgumentException(s"No such color $__color")


