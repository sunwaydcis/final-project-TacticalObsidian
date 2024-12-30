package ChessTutor.models.chessPieces

import scala.collection.mutable.Stack

trait isTakeable //King can never be taken - Ends at checkmate. All else can.

abstract class A_ChessPieces:
  val material: Int
  val color: Null //placeholder
  val position: (Int, Int)
  var moveStack: Stack[(Int, Int)]

  protected def _position: (Int, Int)
  protected def move(position: (Int,Int) = this.position, newPosition: (Int, Int)): Unit
  protected def take(piece: isTakeable): Unit


