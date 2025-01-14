package ChessTutor.models.chessPieces

import zn.makery.ChessTutor.models.casts.Coordinate

import scala.collection.mutable
import scala.collection.mutable.Stack

/**
 * Abstract class representing chess pieces in the game.
 *
 * @constructor Initializes a chess piece with a given alliance (color).
 * @param _color The alliance (color) of the chess piece (e.g., White or Black).
 *
 *               This class extends the `Moveable` trait, indicating that all chess pieces
 *               have the capability to make moves.
 * @note This class is intended to be extended by all chess piece types
 *       (e.g., King, Queen, Rook). It provides common attributes and methods
 *       that are shared across all chess pieces.
 */
abstract class ChessPiece(val _color: Alliance) extends Moveable:
  protected val _symbol: String
  private var _moveStack: Stack[Coordinate] = Stack.empty //Many pieces require the storing of a moveStack. Will be moved to a trait instead

  //getters
  def symbol = _symbol //Will be used to get the text value for UI element. //Break code if color not White or Black
  def color = _color //Important denoting alliance of piece
  def totalMoves = _moveStack.size //Needed by pawns
  def makeMove(newCoordinate: Coordinate) =
    _moveStack.push(newCoordinate)
end ChessPiece



//TRAITS

