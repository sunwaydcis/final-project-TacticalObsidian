package ChessTutor.models

import ChessTutor.models.chessPieces.A_ChessPieces
import scalafx.beans.property.{ObjectProperty, StringProperty}

import java.time.LocalDate

class Game ( //Constructor parameters
             val playerRoleString: String,
             val playerELOString: Int,
             val aiELOString: Int):

  //Defined during / after game creation
  var playerRole = new StringProperty(playerRoleString)
  var playerELO = new StringProperty(playerELOString.toString)
  var aiELO = new StringProperty(aiELOString.toString)
  var datePlayed = ObjectProperty[LocalDate](LocalDate.of(1999, 2, 21))
  private val moveHistory: List[Board] = List.empty
  var currentPlayer: String = "White" //Default
  var captured: List[A_ChessPieces] = List.empty
  var totalMoves = moveHistory.size
  var player1TimeCap = ObjectProperty[Double](0.0)
  var player2TimeCap = ObjectProperty[Double](0.0)
  var totalTime = ObjectProperty[Double](0.0)
  var outcome = new StringProperty("Outcome")
  

