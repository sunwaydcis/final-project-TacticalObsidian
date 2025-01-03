package zn.makery.ChessTutor.models

import ChessTutor.models.chessPieces.A_ChessPieces

case class Moves(piece: A_ChessPieces, oldPosition: Int, newPosition: Int, take: Option[A_ChessPieces]):
  override def toString = String.format(s"${take.map(_ => "#").getOrElse("")}${piece}${newPosition}")
