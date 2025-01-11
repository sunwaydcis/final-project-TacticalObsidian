package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Knight (_color: Alliance) extends A_ChessPieces(_color):
  val directions = List(
    (2, 1),
    (2, -1),
    (1, 2),
    (1, -2),
    (-1, 2),
    (-1, -2),
    (-2, 1),
    (-2, -1)
  )
  
  override val _symbol =
    _color match
      case White => "♘"
      case Black => "♞"
      case _ => throw IllegalArgumentException(s"No such color $_color")

object Knight:
  val material: Int = 3 //All knights are off material 3

