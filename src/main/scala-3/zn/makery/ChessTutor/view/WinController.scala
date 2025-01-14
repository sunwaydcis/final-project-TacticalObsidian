package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import scalafx.Includes.*
import javafx.scene.control.Label
import javafx.scene.shape.Rectangle
import scalafx.stage.Stage
import zn.makery.ChessTutor.LongLiveTheKingApp

class WinController:
  @FXML private var winBox: Label = null

  var dialogStage: Stage = null
  var outcome : String = null
  var okClicked = false

//  def outcome = __outcome

  def handleOk(action: ActionEvent): Unit =
    LongLiveTheKingApp.game=null
    LongLiveTheKingApp.outcome=null
    LongLiveTheKingApp.gameSelectionPane()
    dialogStage.close()


