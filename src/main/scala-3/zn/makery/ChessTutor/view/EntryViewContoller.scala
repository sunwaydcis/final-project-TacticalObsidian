package zn.makery.ChessTutor.view

import zn.makery.ChessTutor.ChessTutorApp
import javafx.event.ActionEvent

/**
 * Not too proud of this being very small.
 */

class EntryViewContoller():
  def handlePlayBtn(action: ActionEvent) =
    val onClick = ChessTutorApp.showGameSelect()

  def handleGameHistoryBtn(action: ActionEvent) =
    val onClick = ChessTutorApp.showGameHistory()