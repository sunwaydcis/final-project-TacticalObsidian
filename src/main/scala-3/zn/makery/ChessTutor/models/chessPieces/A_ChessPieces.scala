package ChessTutor.models.chessPieces

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.Alliance.*
import scala.collection.mutable
import scala.collection.mutable.Stack

abstract class A_ChessPieces(val color: Alliance) extends Moveable:
  val _symbol: String
  var _moveStack: Stack[(Int, Int)] = Stack.empty //Many pieces require the storing of a moveStack. Will be moved to a trait instead

  def moveStack = _moveStack.size

  def move(newCoordinate: (Int, Int)) =
    _moveStack.push(newCoordinate)
end A_ChessPieces



//TRAITS

