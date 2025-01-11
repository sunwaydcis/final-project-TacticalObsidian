package zn.makery.ChessTutor.util

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.*

class Evaluator(board: Board):
  var isCheck: Boolean = false
  
  def moves(piece: A_ChessPieces, row: Int, col: Int) : List[Int] =
    val possibleMoves = piece.moves(row, col)
    possibleMoves
      
    


