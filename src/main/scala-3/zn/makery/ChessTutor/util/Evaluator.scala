package zn.makery.ChessTutor.util

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.*

object Evaluator:
  var isCheck: Boolean = false

  def legalMoves(piece: A_ChessPieces, row: Int, col: Int): List[Int] =
    var legalMoves: List[Int] = List.empty

    piece match
      case pawn: Pawn =>

        //Two-move on start
        legalMoves = legalMoves:+((row + pawn.direction)*8 + col)
        if (piece.moveStack == 0) then
          legalMoves = legalMoves:+ ((row + 2*pawn.direction)*8 + col)
        end if

        //En-passant


        legalMoves

      case _: Knight => ???
      case _: Bishop => ???
      case _: Rook => ???
      case _: Queen => ???
      case _: King => ???
      case _ =>
        null


