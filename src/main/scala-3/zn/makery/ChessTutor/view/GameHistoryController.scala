package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.{Label, TableColumn, TableView}
import scalafx.Includes.*
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import zn.makery.ChessTutor.ChessTutorApp
import zn.makery.ChessTutor.models.Game

import java.time.LocalDate

class GameHistoryController:

  @FXML private var gameHistoryTable : TableView[Game] = null
  @FXML private var dateColumn: TableColumn[Game, LocalDate] = null
  @FXML private var totalTimeColumn: TableColumn[Game, Double] = null
  @FXML private var outcomeColumn: TableColumn[Game, String] = null

  //Player 1 labels - Information
  @FXML private var player1Color: Label = null
  @FXML private var player1Elo: Label = null
  //P1 Moves/Times
  @FXML private var player1TotalMoves: Label = null
  @FXML private var player1TotalTime: Label = null
  //P1 Material
  @FXML private var player1MaterialGained: Label = null
  @FXML private var player1MaterialLost: Label = null
  @FXML private var player1OverallMaterial: Label = null

  //Player 2 labels - Information
  @FXML private var player2Color: Label = null
  @FXML private var player2Elo: Label = null
  //P1 Moves/Times
  @FXML private var player2TotalMoves: Label = null
  @FXML private var player2TotalTime: Label = null
  //P1 Material
  @FXML private var player2MaterialGained: Label = null
  @FXML private var player2MaterialLost: Label = null
  @FXML private var player2OverallMaterial: Label = null


  def initialize() =
    gameHistoryTable.items = ChessTutorApp.gameHistoryData

  def doBackTrack(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showEntryPoint()
  end doBackTrack
  

