package zn.makery.ChessTutor.models

import ChessTutor.models.chessPieces.B_ChessPieces

case class Moves(piece: B_ChessPieces, newPosition: String, take: Option[B_ChessPieces]):
  def move = String.format(s"${take.map(_ => "#").getOrElse("")}$piece $newPosition")
