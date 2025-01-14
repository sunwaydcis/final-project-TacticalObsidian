package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import zn.makery.ChessTutor.ChessTutorApp
import javafx.scene.control.TextField
import scalafx.Includes.*

class GameSelectController:

  @FXML private var whiteName: TextField = null
  @FXML private var blackName: TextField = null

  @FXML private def doPlay_Test(action: ActionEvent): Unit =
    if whiteName.text.value == null then whiteName.text.value = "White"
    if blackName.text.value == null then blackName.text.value = "Black"
    ChessTutorApp.generateGame(whiteName.text.value, blackName.text.value)
    ChessTutorApp.gamePane()

  @FXML private def doBackTrack(action: ActionEvent): Unit = ChessTutorApp.entryPane()

