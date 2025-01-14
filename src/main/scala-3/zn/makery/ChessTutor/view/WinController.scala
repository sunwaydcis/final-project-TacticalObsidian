package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import scalafx.Includes.*
import javafx.scene.control.Label
import javafx.scene.shape.Rectangle
import scalafx.stage.Stage
import zn.makery.ChessTutor.ChessTutorApp

class WinController():
  @FXML private var winTxt: Label = null
  var dialogStage: Stage = null
  var outcome : String = null
  var okClicked = false

  def initialize =
    winTxt.text = outcome

  def handleOk(action: ActionEvent): Unit =
    ChessTutorApp.game=null
    ChessTutorApp.gameSelectionPane()
    dialogStage.close()


