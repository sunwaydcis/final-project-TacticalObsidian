package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import zn.makery.ChessTutor.DownWithTheKingApp
import javafx.scene.control.TextField
import scalafx.Includes.*

class GameOptions:

  @FXML private var whiteName: TextField = _
  @FXML private var blackName: TextField = _

  @FXML private def doPlay_Test(action: ActionEvent): Unit =
    val onClick =
        DownWithTheKingApp.generateGame(whiteName.text.value, blackName.text.value)
        DownWithTheKingApp.gameView

  @FXML private def doBackTrack(action: ActionEvent): Unit = DownWithTheKingApp.entryView 

