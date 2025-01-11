package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Knight (_color: Alliance) extends A_ChessPieces(_color):
  override val material = 3
  override val _symbol =
    _color match
      case White => "♘"
      case Black => "♞"
      case _ => throw IllegalArgumentException(s"No such color $_color")

object Knight:
  val material: Int = 3 //All knights are off material 3

