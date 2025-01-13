package zn.makery.ChessTutor.util

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.*

object ChessEngine:
  var isCheck: Boolean = false
  
  def legalMoves(board: Board, piece: A_ChessPieces, row: Int, col: Int) : List[Int] =
    val possibleMoves = piece.moves(board, row, col)
    possibleMoves.filter(index => isLegal(index))

  private def isLegal(index: Int): Boolean =
    val targetRow = index / 8
    val targetCol = index % 8
    true



      
    


