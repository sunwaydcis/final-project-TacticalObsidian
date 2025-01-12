package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Rook (_color: Alliance) extends A_ChessPieces(_color) with Crosser:
  
  override val _symbol =
    _color match
      case White => "♖"
      case Black => "♜"
      case _ => throw IllegalArgumentException(s"No such color $_color")



object Rook:
  val material: Int = 5 //All bishops are off material 3

