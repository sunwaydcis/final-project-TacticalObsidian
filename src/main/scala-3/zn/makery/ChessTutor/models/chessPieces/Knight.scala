package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Knight (_color: Alliance) extends A_ChessPieces(_color) with Octet with ShortTraversable:

  override val _symbol: String =
    _color match
      case White => "♘"
      case Black => "♞"
      case null => throw IllegalArgumentException(s"No such color $_color")

object Knight:
  val material: Int = 3 //All knights are off material 3

