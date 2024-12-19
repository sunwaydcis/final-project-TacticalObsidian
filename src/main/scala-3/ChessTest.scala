import Symbol.*
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

//To make typecasting much easier and less verbose
type Board = Array[Array[Option[BoardPiece]]]
type Position = (Int, Int)

enum Color:
  case White, Black, Blank


enum Symbol:
  case Pawn, Bishop, Knight, Rook, Queen, King

trait ChessPiece:
  def symbol: String
  def color: Color
  def move(): Unit

case class BoardPiece(var chessSymbol: Symbol, var color: Color):
  def symbol: String =
    chessSymbol match
      case Pawn => if color == White then "♙" else "♟"
      case Bishop => if color == White then "♗" else "♝"
      case Knight => if color == White then "♘" else "♞"
      case Rook => if color == White then "♖" else "♜"
      case Queen => if color == White then "♕" else "♛"
      case King => if color == White then "♔" else "♚"

object Symbol:
  private val color = Color

//UPGRADE
trait ChessPiece2:
  def symbol: String
  def color: Color
  def position: (Int, Int)
  def legalMoves(position: Position = this.position, board: Board): List[Position]




object MyApp extends App:

  private def buildBoard(): Board =
    val board = Array.fill(8, 8)(Option.empty[BoardPiece])

    // Major Pieces
    val majorPiecesBlack = Array(
      BoardPiece(Rook, Black),
      BoardPiece(Knight, Black),
      BoardPiece(Bishop, Black),
      BoardPiece(King, Black),
      BoardPiece(Queen, Black),
      BoardPiece(Bishop, Black),
      BoardPiece(Knight, Black),
      BoardPiece(Rook, Black)
    )

    val majorPiecesWhite = Array(
      BoardPiece(Rook, White),
      BoardPiece(Knight, White),
      BoardPiece(Bishop, White),
      BoardPiece(King, White),
      BoardPiece(Queen, White),
      BoardPiece(Bishop, White),
      BoardPiece(Knight, White),
      BoardPiece(Rook, White)
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
    end for
  end printBoard

  private val board = buildBoard()
  printBoard(board)

//Not a clue how to do it yet, will hold it off for now
////Use factories to centralize development logic
//object BoardFactory:
//  def standardBoard(): Board =
//    val board = Array.fill(8, 8)(Option.empty[BoardPiece])
//
//    for i <- 0 until 8 do
//
//      end for
//    board
//
//
//object ChessPieceFactory:
//  def createNewPiece(piece: Symbol, color: Color): BoardPiece =
//    piece match
//      case Pawn =>  BoardPiece(color)
//      case Bishop =>
//      case Knight =>
//      case Rook =>
//      case Queen =>
//      case King =>
//      case _ =>
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
//case class Symbol(val color: Color)

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