package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Queen (_color: Alliance) extends A_ChessPieces(_color):
  val directions = List(
    (0,1),
    (1,0),
    (0,-1),
    (-1,0),
    (1, 1),
    (1, -1),
    (-1, 1),
    (-1, -1)
  )
  
  override val _symbol =
    _color match
      case White => "♕"
      case Black => "♛"
      case _ => throw IllegalArgumentException(s"No such color $_color")


object Queen:
  val material: Int = 9 //All bishops are off material 3

