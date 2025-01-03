package ChessTutor.models

import ChessTutor.models.chessPieces.A_ChessPieces
import scalafx.beans.property.{DoubleProperty, ObjectProperty, StringProperty}

import java.time.LocalDate

class Game ( //Constructor parameters
             val playerRole: String,
             val playerELO: Int,
             val aiELO: Int):

  //Defined during / after game creation
  var datePlayed = ObjectProperty[LocalDate](LocalDate.of(1999, 2, 21))
  var moveHistory: List[Board] = List.empty
  var currentPlayer: String = "White" //Default
  var captured: List[A_ChessPieces] = List.empty
  var totalMoves = moveHistory.size
  var player1TimeCap = ObjectProperty[Double](0.0)
  var player2TimeCap = ObjectProperty[Double](0.0)
  var totalTime = ObjectProperty[Double](0.0)
  var outcome = new StringProperty("Outcome")
  

