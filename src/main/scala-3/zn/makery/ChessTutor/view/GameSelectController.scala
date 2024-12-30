package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import zn.makery.ChessTutor.ChessTutorApp

class GameSelectController():
  /** CODE RESPONSIBILITY - Control the view logic
   *  The outcome of certain views, can lead to the creation of a game instance object.
   */

  def doPlay_Test(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showGame()
  end doPlay_Test

  def doBackTrack(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showEntryPoint()
  end doBackTrack
