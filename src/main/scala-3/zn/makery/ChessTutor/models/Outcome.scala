package zn.makery.ChessTutor.models

import scalafx.beans.property.{IntegerProperty, ObjectProperty, StringProperty}

import java.time.LocalDate

case class Outcome(outcomeString: String, board:Board2, datePlayedValue: LocalDate):
  var outcome = new StringProperty(outcomeString)
  var datePlayed = ObjectProperty[LocalDate](datePlayedValue)
  var totalMoves = IntegerProperty(board.totalMoves)
  
  
case class Game2(whiteName: String, blackName: String)