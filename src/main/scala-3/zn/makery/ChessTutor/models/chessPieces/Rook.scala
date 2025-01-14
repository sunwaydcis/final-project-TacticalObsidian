package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Rook (__color: Alliance) extends B_ChessPieces(__color) with Crosser:
  
  override val _symbol =
    __color match
      case White => "♖"
      case Black => "♜"
      case _ => throw IllegalArgumentException(s"No such color $__color")

