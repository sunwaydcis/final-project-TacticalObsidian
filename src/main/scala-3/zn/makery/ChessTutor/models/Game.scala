package zn.makery.ChessTutor.models

import ChessTutor.models.Board
import scalafx.collections.ObservableBuffer

class Game(private val _whiteName: String, private val _blackName: String, private val _board: Board):
  private val _moves = ObservableBuffer[Moves]()
  
  def board: Board=
    _board
  
  def blackName=
    _blackName
  
  def whiteName =
    _whiteName
  
  def moves =
    _moves