package ChessTutor.models.chessPieces

import zn.makery.ChessTutor.models.casts.Coordinate

import scala.collection.mutable
import scala.collection.mutable.Stack

abstract class B_ChessPieces(private val _color: Alliance) extends Moveable:
  protected val _symbol: String
  protected var _moveStack: Stack[Coordinate] = Stack.empty //Many pieces require the storing of a moveStack. Will be moved to a trait instead

  def color = _color

  def symbol = _symbol

  def totalMoves = _moveStack.size

  def move(newCoordinate: Coordinate) =
    _moveStack.push(newCoordinate)
end B_ChessPieces



//TRAITS

