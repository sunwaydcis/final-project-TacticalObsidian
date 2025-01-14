package zn.makery.ChessTutor.models

import ChessTutor.models.chessPieces.BaseChessPiece

case class Moves(piece: BaseChessPiece, newPosition: String, take: Option[BaseChessPiece]):
  def move = String.format(s"${take.map(_ => "#").getOrElse("")}$piece $newPosition")
