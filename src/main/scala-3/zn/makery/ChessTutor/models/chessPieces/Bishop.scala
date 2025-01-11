package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Bishop (_color: Alliance) extends A_ChessPieces(_color):
  val directions = List(
    (1, 1),
    (1, -1),
    (-1, 1),
    (-1, -1)
  )

  override val material = 3
  override val _symbol =
    _color match
      case White => "♗"
      case Black => "♝"
      case _ => throw IllegalArgumentException(s"No such color $_color")


object Bishop:
  val material: Int = 3 //All bishops are off material 3
