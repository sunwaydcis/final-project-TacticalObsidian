import ChessPiece.*
import Color.*

/** BY: ZAR NIE AUNG (BSE_21074380)
 *
 *
 * Good day Dr Chin, for my OOP FA, I aim to develop a simple AI chess program.
 * The main focus of this code is to offer users a personalized AI opponent, that will always be:
 * (50 - 1000 ELO) above the user's skill grade to offer a more personalized challenge and facilitate learning.
 *
 * The reasoning behind my project is because many mainstream chess games, most popular being chess.com,
 * is that they do not offer such learning advantages. Players must find where they belong first, and deal with an
 * AI bot that is often either too high or too low. I want to offer users (myself primarily) with a software
 * that I can use to learn chess with a challenge that facilitates my learning needs best.
 *
 * Yes, there still carries a lot of benefit for having these other chess bots to fight against,
 * at least 3 AI bots will remain.
 *
 *  The purpose of this code is to test the feasibility of the idea, using the Scala CLI terminal as the main UI component.
 */

enum Color:
  case White, Black, Blank

enum ChessPiece:
  case Pawn, Bishop, Knight, Rook, Queen, King

case class BoardPiece(var chessPiece: ChessPiece, var color: Color):
  def symbol: String =
    chessPiece match
      case Pawn => if color == White then "♙" else "♟"
      case Bishop => if color == White then "♗" else "♝"
      case Knight => if color == White then "♘" else "♞"
      case Rook => if color == White then "♖" else "♜"
      case Queen => if color == White then "♕" else "♛"
      case King => if color == White then "♔" else "♚"



//Not a clue how to do it yet, will hold it off for now
//enum Piece:
//  case Pawn, Knight, Bishop, Rook, Queen, King
//
//trait ChessSymbol:
//  def color: Color
//  def symbol: String
//  def piece: Piece
//  def legalMoves (position: (Int, Int), board: Board): List[(Int, Int)]
//
////enum ChessSymbol:
////  case ♜, ♞, ♝, ♛, ♚, ♟, ♖, ♘, ♗, ♕, ♔, ♙
//
//case class ChessPiece(val color: Color)

//trait ChessSymbol:
//  def symbol: String


//trait FullDiagonal
//trait FullBar
//trait KnightJump
//trait Promote
//trait EnPassant
//trait CastleAble
//
//object Rook extends FullBar
//object Bishop extends FullDiagonal
//object Queen extends FullBar, FullDiagonal

object ChessPiece:
  private val color = Color

type Board = Array[Array[Option[BoardPiece]]]

object MyApp extends App:

  private def buildBoard(): Board =
    val board = Array.fill(8, 8)(Option.empty[BoardPiece])

    // Major Pieces
    val majorPiecesBlack = Array(
      BoardPiece(ChessPiece.Rook, Color.Black),
      BoardPiece(ChessPiece.Knight, Color.Black),
      BoardPiece(ChessPiece.Bishop, Color.Black),
      BoardPiece(ChessPiece.King, Color.Black),
      BoardPiece(ChessPiece.Queen, Color.Black),
      BoardPiece(ChessPiece.Bishop, Color.Black),
      BoardPiece(ChessPiece.Knight, Color.Black),
      BoardPiece(ChessPiece.Rook, Color.Black)
    )

    val majorPiecesWhite = Array(
      BoardPiece(ChessPiece.Rook, Color.White),
      BoardPiece(ChessPiece.Knight, Color.White),
      BoardPiece(ChessPiece.Bishop, Color.White),
      BoardPiece(ChessPiece.King, Color.White),
      BoardPiece(ChessPiece.Queen, Color.White),
      BoardPiece(ChessPiece.Bishop, Color.White),
      BoardPiece(ChessPiece.Knight, Color.White),
      BoardPiece(ChessPiece.Rook, Color.White)
    )

    for i <- 0 until 8 do
      board(0)(i) = Some(majorPiecesBlack(i))
      board(1)(i) = Some(BoardPiece(Pawn, Black)) //black pawns
      board(6)(i) = Some(BoardPiece(Pawn, White)) //white pawns
      board(7)(i) = Some(majorPiecesWhite(i))

    board
  end buildBoard

  private def printBoard(board: Board): Unit =
    for row <- board do
      println(row.map{
        case Some(piece) => f"[${piece.symbol}]"
        case None => "[#]"
      }.mkString)
//      // Square Top
//      println(row.map(_ => " ___").mkString(" "))
//
//      // Square Middle
//      println(row.map {
//        case Some(piece) => f"| ${piece.symbol} |" //Filled Square
//        case None => "|    |" // Empty square
//      }.mkString(""))
//
//      // Square Bottom
//      println(row.map(_ => "|___|").mkString(""))
    end for
  end printBoard

  private val board = buildBoard()
  printBoard(board)





  buildBoard()