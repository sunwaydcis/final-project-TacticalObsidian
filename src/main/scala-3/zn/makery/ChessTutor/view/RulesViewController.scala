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

class RulesViewController():
  var dialogStage: Stage = null
  var okClicked = false

  def handleUnderstand(action: ActionEvent): Unit =
    dialogStage.close()


