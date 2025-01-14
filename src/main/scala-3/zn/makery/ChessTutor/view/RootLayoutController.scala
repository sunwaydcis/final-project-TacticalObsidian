package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import zn.makery.ChessTutor.LongLiveTheKingApp

class RootLayoutController:
  def helpPane(action: ActionEvent): Unit =
    LongLiveTheKingApp.helpPane()
