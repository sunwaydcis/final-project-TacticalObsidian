package ChessTutor.models.chessPieces

import zn.makery.ChessTutor.models.casts.Coordinate

import scala.collection.mutable
import scala.collection.mutable.Stack

abstract class BaseChessPiece(val color: Alliance) extends Moveable:
  val symbol: String
  val material: Int = 0
  var _moveStack: Stack[Coordinate] = Stack.empty //Many pieces require the storing of a moveStack. Will be moved to a trait instead

  def moveStack = _moveStack.size

  def move(newCoordinate: Coordinate) =
    _moveStack.push(newCoordinate)
end BaseChessPiece
