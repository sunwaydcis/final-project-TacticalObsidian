package zn.makery.ChessTutor.models

import ChessTutor.models.Board
import scalafx.collections.ObservableBuffer

class Game(_whiteName: String, _blackName: String, _board: Board):
  var _moves = ObservableBuffer[Moves]()
  
  def board: Board=
    _board
  
  def blackName=
    _blackName
  
  def whiteName =
    _whiteName
  
  def moves =
    _moves