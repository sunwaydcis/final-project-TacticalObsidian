package zn.makery.ChessTutor.models

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.A_ChessPieces
import scalafx.beans.property.{ObjectProperty, StringProperty}

import java.time.LocalDate

class newGame(player1Color: String, player1TimeCap: Option[Double], player2TimeCap: Option[Double], aiELO: Int):
  //Game info variables
  var outcome = new StringProperty("Outcome")
  var totalTime = ObjectProperty[Double](0.0)
  var datePlayed = ObjectProperty[LocalDate](LocalDate.of(1999, 2, 21))

  //Game variables
  var _currentPlayer: String = "White" //Default
  var moveHistory: List[Board] = List.empty
  var captured: List[A_ChessPieces] = List.empty
  var board: Option[Board] = None
  val movesList : List[Moves] = List.empty

  def nextPlayer(nextPlayer: String): Unit =
    currentPlayer_=(nextPlayer)

  //Setter current player
  private def currentPlayer_=(nextPlayer: String): Unit =
    _currentPlayer = nextPlayer