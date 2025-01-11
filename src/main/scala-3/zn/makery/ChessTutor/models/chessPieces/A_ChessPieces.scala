package ChessTutor.models.chessPieces

import scala.collection.mutable.Stack

trait Moveable:
  val directions: List[Int]

enum Alliance:
  case White, Black

abstract class A_ChessPieces(val color: Alliance):
  val _symbol: String
  val material: Int = 0
  var _moveStack: Stack[(Int, Int)] = Stack.empty //Many pieces require the storing of a moveStack. Will be moved to a trait instead
  
  def moveStack = _moveStack.size
  def move(newCoordinate: (Int, Int)) =
    _moveStack.push(newCoordinate)
    
//  def symbol: String
//  def symbol_=(newSymbol:String): Unit =
//    _symbol = newSymbol 

/**Yes, though moves are a part of the chess pieces. In this implementation, they are purely symbolic
 * The moves of each chess piece will be evaluated by ChessEngine.
 * Therefore, all chessPiece classes will only carry material/visual information
 */

  