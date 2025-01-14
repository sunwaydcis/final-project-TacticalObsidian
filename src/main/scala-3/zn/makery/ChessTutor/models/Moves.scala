package zn.makery.ChessTutor.models

import ChessTutor.models.chessPieces.B_ChessPieces

case class Moves(private val piece: B_ChessPieces, private val newPosition: String, private val take: Option[B_ChessPieces]):
  def move: String = String.format(s"${piece.symbol}${take.map(_ => s"#").getOrElse("")}$newPosition")
