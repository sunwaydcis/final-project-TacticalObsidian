package zn.makery.ChessTutor.models

import ChessTutor.models.chessPieces.{A_ChessPieces, Alliance}
import scalafx.collections.ObservableBuffer

class Board2:
  val maxSize = 8
  private val board = Map[A_ChessPieces, (Int, Int)]()
  private val captures = Map[Alliance, A_ChessPieces]()
  
  private val _moves = ObservableBuffer[Moves]()
  
  def moves = _moves
  def totalMoves = _moves.size
  
  def position(piece: A_ChessPieces) =
    board.get(piece)
      
  def piece(position: (Int, Int)) =
    board.find((_, pos) => pos == position)
  
  def movePiece(piece: A_ChessPieces, newPosition: (Int, Int)) =
    removePiece(piece)
    placePiece(piece, newPosition)

    //Returns a letter for correspondent board column
    val column = newPosition._2 match
      case 0 => "A"
      case 1 => "B"
      case 2 => "C"
      case 3 => "D"
      case 4 => "E"
      case 5 => "F"
      case 6 => "G"
      case 7 => "H"

    //Returns chess correct position (Example: (0, 7) => h1
    val position = String.format(s"$column${newPosition._1}")
    
    _moves += Moves(piece, position, None)
  
  def placePiece(piece: A_ChessPieces, position: (Int, Int)) =
    board + (piece -> position)

  def removePiece(piece: A_ChessPieces) =
    board - piece
