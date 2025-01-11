package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance.*

class Pawn (_color: Alliance) extends A_ChessPieces(_color):
  override val _symbol =
    _color match
      case White => "♙"
      case Black => "♟"
      case _ => throw IllegalArgumentException(s"No such color $_color")

  val direction : Int =
    _color match
      case White => -1
      case Black => 1

object Pawn:
  val material: Int = 1


