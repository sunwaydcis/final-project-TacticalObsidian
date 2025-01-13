package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import scalafx.Includes.*
import javafx.scene.control.Label
import javafx.scene.shape.Rectangle
import scalafx.stage.Stage
import zn.makery.ChessTutor.ChessTutorApp

class WinController():
  @FXML private var winBox: Label = null
  @FXML private var winBkg: Rectangle = null

  var dialogStage: Stage = null
  var outcome : String = null
  var okClicked = false

//  def outcome = __outcome

  def handleOk(action: ActionEvent): Unit =
    ChessTutorApp.game=null
    ChessTutorApp.outcome=null
    ChessTutorApp.gameSelectionPane()
    dialogStage.close()


