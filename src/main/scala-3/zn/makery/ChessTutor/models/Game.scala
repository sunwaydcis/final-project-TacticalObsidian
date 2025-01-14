package zn.makery.ChessTutor.models

import ChessTutor.models.Board
import scalafx.collections.ObservableBuffer

/**
 * Represents a chess game between two players.
 * @param _whiteName The name of the player using white pieces.
 * @param _blackName The name of the player using black pieces.
 * @param _board     The board on which the game is played.
 */
class Game(val _whiteName: String, val _blackName: String, val _board: Board):
  var _moves = ObservableBuffer[Moves]() //Stores the moves that occur throughout the game - tobe observed by moves table in GVC
  
  def board: Board=
    _board
  
  def blackName=
    _blackName
  
  def whiteName =
    _whiteName
  
  def moves =
    _moves