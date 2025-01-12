package zn.makery.ChessTutor.models

import ChessTutor.models.chessPieces.A_ChessPieces

case class Moves(piece: A_ChessPieces, newPosition: String, take: Option[A_ChessPieces]):
  def move = String.format(s"${take.map(_ => "#").getOrElse("")}$piece $newPosition")
