package ChessTutor.models

import ChessTutor.models.chessPieces.Alliance.*
import ChessTutor.models.chessPieces.*
import zn.makery.ChessTutor.models.casts.Coordinate

/**
 * Represents a chess board for managing the positions of chess pieces and their movement.
 *
 * The board is an 8x8 grid, with each cell holding an optional chess piece. It maintains 
 * the positions of all pieces on the board and provides methods to initialize the board, 
 * query positions, and manage piece movements.
 */
class Board:
  private val _board: Array[Array[Option[ChessPiece]]] = Array.fill(8, 8)(None) //piece grid positioning
  private var _piecePositions = Map[ChessPiece, Coordinate]() //piece locating

  def initialize(): Unit =
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

  def board: Array[Array[Option[ChessPiece]]] = 
    _board
  def piecePositions: Map[ChessPiece, (Int, Int)] = 
    _piecePositions
  def positionOf(piece: ChessPiece): Coordinate = 
    _piecePositions.get(piece).get
  def pieceAt(row: Int, col: Int): Option[ChessPiece] = 
    _board(row)(col)

  /**
   * Moves a chess piece to a new position on the board and updates the piece's move history.
   *
   * @param piece  The chess piece to be moved.
   * @param newRow The row index of the target position on the board.
   * @param newCol The column index of the target position on the board.
   */
  def movePiece(piece: ChessPiece, newRow: Int, newCol: Int) =
    val position: Option[(Int, Int)] = _piecePositions.get(piece)
    removePiece(piece, position.get(0), position.get(1))
    placePiece(piece, newRow, newCol)
    piece.makeMove((newRow, newCol))
  
  private def placePiece(piece: ChessPiece, row: Int, col: Int) =
    _board(row)(col) = Some(piece)
    _piecePositions += (piece -> (row, col))

  private def removePiece(piece: ChessPiece, row: Int, col: Int) =
    _board(row)(col) = None
    _piecePositions = _piecePositions - piece







