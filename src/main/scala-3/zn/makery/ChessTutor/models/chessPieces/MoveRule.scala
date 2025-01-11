package zn.makery.ChessTutor.models.chessPieces

import ChessTutor.models.Board

trait MoveRule:
  def legalMoves(board: Board): List[Int]