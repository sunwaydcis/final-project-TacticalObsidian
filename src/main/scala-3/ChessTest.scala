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
  case white, black, none

class ChessPiece

object ChessPiece:
  val color = Color

type Board = Array[Array[Option[ChessPiece]]]

object MyApp extends App:

  def buildBoard(): Board =
    val board = Array.fill(8, 8)(Option.empty[ChessPiece])
    return board
  end buildBoard

  def printBoard(board: Board): Unit =
    for row <- board do
      println(row.map{
        case Some(piece) => "W"
        case None => "[ ]"
      }.mkString(" "))
      println()
  end printBoard

  val board = buildBoard()
  printBoard(board)





  buildBoard()