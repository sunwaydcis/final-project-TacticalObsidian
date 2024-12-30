package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import zn.makery.ChessTutor.ChessTutorApp

class GameHistoryController:

  def doBackTrack(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showEntryPoint()
  end doBackTrack
