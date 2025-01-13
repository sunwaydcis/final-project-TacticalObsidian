package ChessTutor.models

import ChessTutor.models.chessPieces.Alliance.*
import ChessTutor.models.chessPieces._

type BoardCoordinate = (Int, Int)

class Board:
  var board: Array[Array[Option[A_ChessPieces]]] = Array.fill(8, 8)(None)
  private var piecePositions : Map[A_ChessPieces, BoardCoordinate] = Map.empty

  def init: Unit =
    for i <- 0 until 8 do
      placePiece(new Pawn(White), 6, i)
      placePiece(new Pawn(Black), 1, i)
    
    placePiece(new Rook(White), 7, 0)
    placePiece(new Knight(White), 7, 1)
    placePiece(new Bishop(White), 7, 2)
    placePiece(new Queen(White), 7, 3)
    placePiece(new King(White), 7, 4)
    placePiece(new Bishop(White), 7, 5)
    placePiece(new Knight(White), 7, 6)
    placePiece(new Rook(White), 7, 7)

    placePiece(new Rook(Black), 0, 0)
    placePiece(new Knight(Black), 0, 1)
    placePiece(new Bishop(Black), 0, 2)
    placePiece(new Queen(Black), 0, 3)
    placePiece(new King(Black), 0, 4)
    placePiece(new Bishop(Black), 0, 5)
    placePiece(new Knight(Black), 0, 6)
    placePiece(new Rook(Black), 0, 7)

  def position(piece: A_ChessPieces) =
    piecePositions.get(piece)

  def piece(row: Int, col: Int) = board(row)(col)

  def movePiece(piece: A_ChessPieces, newRow: Int, newCol: Int) =
    val position: Option[(Int, Int)] = piecePositions.get(piece)
    removePiece(piece, position.get(0), position.get(1))
    placePiece(piece, newRow, newCol)
    piece._moveStack.push((newRow, newCol))

  private def placePiece(piece: A_ChessPieces, row: Int, col: Int) =
    board(row)(col) = Some(piece)
    piecePositions += (piece -> (row, col))

    piece match
      case pawn: Pawn =>
        if position(pawn).get._1 == 7 && pawn.color == Black then pawn.promote
        else if position(pawn).get._1 == 0 && pawn.color == White then pawn.promote
      case _ =>
        //do nothing

  private def removePiece(piece: A_ChessPieces, row: Int, col: Int) =
    board(row)(col) = None
    piecePositions = piecePositions - piece






