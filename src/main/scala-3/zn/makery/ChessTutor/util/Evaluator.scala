package zn.makery.ChessTutor.util

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.*

class Evaluator(board: Board):
  var isCheck: Boolean = false

  //TO BE Generic
  def legalMoves(piece: A_ChessPieces, row: Int, col: Int): List[Int] =
    var legalMoves: List[Int] = List.empty

    piece match
      case pawn: Pawn =>
        //Two-move on start
        legalMoves = legalMoves:+((row + pawn.direction)*8 + col)
        if (piece.moveStack == 0) then
          legalMoves = legalMoves:+ ((row + 2*pawn.direction)*8 + col)
        end if
        legalMoves

        //En-passant

      case knight: Knight =>
        for (dr, dc) <- knight.directions do
          var boardRow = row + dr
          var boardCol = col + dc
          // Continue in the direction until we hit the edge of the board or another piece
          while boardRow >= 0 && boardRow < 8 && boardCol >= 0 && boardCol < 8 do
            println(s"${boardRow}, ${boardCol}")
            board.piece(boardRow, boardCol) match
              case None =>
                // Add empty square as a valid move
                legalMoves = legalMoves :+ (boardRow * 8 + boardCol)
              case Some(piece) =>
                // If the piece is of the opposite color, add as a valid move and stop
                if piece.color != knight.color then
                  legalMoves = legalMoves :+ (boardRow * 8 + boardCol)
            // Stop if any piece is encountered
            boardRow = -1
            boardCol = -1 // This will break the while loop
        legalMoves

      case bishop: Bishop =>
        // Iterate through each direction
        for (dr, dc) <- bishop.directions do
          var boardRow = row + dr
          var boardCol = col + dc
          // Continue in the direction until we hit the edge of the board or another piece
          while boardRow >= 0 && boardRow < 8 && boardCol >= 0 && boardCol < 8 do
            println(s"Checking position ($boardRow, $boardCol)") // Debug print
            board.piece(boardRow, boardCol) match
              case None =>
                // Add empty square as a valid move
                legalMoves = legalMoves :+ (boardRow * 8 + boardCol)
              case Some(p) =>
                // If the piece is of the opposite color, add as a valid move and stop
                if p.color != bishop.color then
                  legalMoves = legalMoves :+ (boardRow * 8 + boardCol)
                // Stop if any piece is encountered
                boardRow = -1
                boardCol = -1 // This will break the while loop
            // Update the loop variables to continue in the direction
            if boardRow != -1 && boardCol != -1 then
              boardRow += dr
              boardCol += dc
        legalMoves

      case rook: Rook =>
        for (dr, dc) <- rook.directions do
          var boardRow = row+dr
          var boardCol = col+dc
          // Continue in the direction until we hit the edge of the board or another piece
          while boardRow >= 0 && boardRow < 8 && boardCol >= 0 && boardCol < 8 do
            println(s"${boardRow}, ${boardCol}")
            board.piece(boardRow, boardCol) match
              case None =>
                // Add empty square as a valid move
                legalMoves = legalMoves :+ (boardRow * 8 + boardCol)
              case Some(piece) =>
                // If the piece is of the opposite color, add as a valid move and stop
                if piece.color != rook.color then
                  legalMoves = legalMoves :+ (boardRow * 8 + boardCol)
                // Stop if any piece is encountered
                boardRow = -1
                boardCol = -1 // This will break the while loop
            // Update the loop variables to continue in the direction
            if boardRow != -1 && boardCol != -1 then
              boardRow += dr
              boardCol += dc
        legalMoves

      case queen: Queen =>
        for (dr, dc) <- queen.directions do
          var boardRow = row+dr
          var boardCol = col+dc
          // Continue in the direction until we hit the edge of the board or another piece
          while boardRow >= 0 && boardRow < 8 && boardCol >= 0 && boardCol < 8 do
            println(s"${boardRow}, ${boardCol}")
            board.piece(boardRow, boardCol) match
              case None =>
                // Add empty square as a valid move
                legalMoves = legalMoves :+ (boardRow * 8 + boardCol)
              case Some(piece) =>
                // If the piece is of the opposite color, add as a valid move and stop
                if piece.color != queen.color then
                  legalMoves = legalMoves :+ (boardRow * 8 + boardCol)
                // Stop if any piece is encountered
                boardRow = -1
                boardCol = -1 // This will break the while loop
            // Update the loop variables to continue in the direction
            if boardRow != -1 && boardCol != -1 then
              boardRow += dr
              boardCol += dc
        legalMoves

      case king: King =>
        for (dr, dc) <- king.directions do
          var boardRow = row+dr
          var boardCol = col+dc
          // Continue in the direction until we hit the edge of the board or another piece
          while boardRow >= 0 && boardRow < 8 && boardCol >= 0 && boardCol < 8 do
            println(s"${boardRow}, ${boardCol}")
            board.piece(boardRow, boardCol) match
              case None =>
                // Add empty square as a valid move
                legalMoves = legalMoves :+ (boardRow * 8 + boardCol)
              case Some(piece) =>
                // If the piece is of the opposite color, add as a valid move and stop
                if piece.color != king.color then
                  legalMoves = legalMoves :+ (boardRow * 8 + boardCol)
                // Stop if any piece is encountered
            boardRow = -1
            boardCol = -1 // This will break the while loop
        legalMoves
      case _ =>
        null


