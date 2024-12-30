package zn.makery.ChessTutor.models.player

abstract class A_Player(var _elo: Int, var _color: String):
  def elo = _elo
  def elo_=(newElo: Int) =
    _elo = newElo
  end elo_=
  
  def color = _color
  def color_=(newColor: String) =
    _color = newColor
