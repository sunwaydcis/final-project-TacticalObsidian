package zn.makery.ChessTutor.view

import ChessTutor.models.chessPieces.Alliance
import javafx.event.ActionEvent
import javafx.fxml.FXML
import scalafx.Includes.*
import javafx.scene.control.Label
import javafx.scene.paint.Color._
import javafx.scene.shape.Rectangle
import scalafx.stage.Stage
import zn.makery.ChessTutor.LongLiveTheKingApp

class WinController():
  @FXML private var winTxt: Label = null
  @FXML private var winBkg: Rectangle = null
  var dialogStage: Stage = null
  var color : Option[Alliance] = null
  var outcome : String = null
  var okClicked = false

  def initialize =
    winTxt.text = outcome
    winBkg.fill =
      color match
        case Some(Alliance.White) => LIGHTGRAY
        case Some(Alliance.Black) => DARKGRAY
        case _ => MAROON

  def handleOk(action: ActionEvent): Unit =
    LongLiveTheKingApp.game=null
    LongLiveTheKingApp.gameSelectionPane()
    dialogStage.close()


