package ChessTutor.models.chessPieces

import scala.collection.mutable.Stack

abstract class ChessPieces:
  val material: Int
  val color: Null //placeholder
  val position: (Int, Int)
  var moveStack: Stack[(Int, Int)]

  def move(position: (Int,Int) = this.position, newPosition: (Int, Int)): Unit

