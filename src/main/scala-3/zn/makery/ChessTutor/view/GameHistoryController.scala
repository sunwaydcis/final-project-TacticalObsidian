package zn.makery.ChessTutor.view

import ChessTutor.models.Game
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.{Label, TableColumn, TableView}
import scalafx.Includes.*
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import zn.makery.ChessTutor.ChessTutorApp

import java.time.LocalDate

class GameHistoryController:

  @FXML private var gameHistoryTable : TableView[Game] = null
  @FXML private var dateColumn: TableColumn[Game, LocalDate] = null
  @FXML private var totalTimeColumn: TableColumn[Game, Double] = null
  @FXML private var outcomeColumn: TableColumn[Game, String] = null


  def initialize() =
    gameHistoryTable.items = ChessTutorApp.gameHistoryData
    //BIND CELLS
    dateColumn.cellValueFactory = _.value.datePlayed
    totalTimeColumn.cellValueFactory = _.value.totalTime
    outcomeColumn.cellValueFactory = _.value.outcome


  def doBackTrack(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showEntryPoint()
  end doBackTrack
