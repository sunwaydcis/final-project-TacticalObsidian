package zn.makery.ChessTutor.models

import ChessTutor.models.chessPieces.ChessPiece

case class Moves(piece: ChessPiece, newPosition: String, take: Option[ChessPiece]):
  def move = String.format(s"${take.map(_ => "#").getOrElse("")}${piece.symbol} $newPosition")
