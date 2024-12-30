package zn.makery.ChessTutor.view

import zn.makery.ChessTutor.ChessTutorApp
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.{Label, TableColumn, TableView}
import scalafx.Includes.*
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType

class EntryViewContoller():
  def handlePlayBtn(action: ActionEvent) =
    val onClick = ChessTutorApp.showGameSetting()

  def handleGameHistoryBtn(action: ActionEvent) =
    val onClick = ChessTutorApp.showGameHistory()

