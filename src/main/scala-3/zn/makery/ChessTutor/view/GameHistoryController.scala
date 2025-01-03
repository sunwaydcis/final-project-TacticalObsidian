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
    //BIND CELLS
    dateColumn.cellValueFactory = _.value.datePlayed
    totalTimeColumn.cellValueFactory = _.value.totalTime
    outcomeColumn.cellValueFactory = _.value.outcome

//  private def showGameOverview(game: Option[Game]): Unit =
//    game match
//      case Some(game) =>
//        player1Color.text <== game.playerRole
//        player1Elo.text <== game.playerELO
//        player1TotalMoves.text <== game.playerELO //stand in
//        player1TotalTime.text <== game.playerELO
//        player1MaterialGained.text <== game.playerELO
//        player1MaterialLost.text <== game.playerELO
//        player1OverallMaterial.text <== game.playerELO
//
//        player2Color.text <== game.playerRole //stand in
//        player2Elo.text <== game.aiELO
//        player2TotalMoves.text <== game.playerELO //stand in
//        player2TotalTime.text <== game.playerELO
//        player2MaterialGained.text <== game.playerELO
//        player2MaterialLost.text <== game.playerELO
//        player2OverallMaterial.text <== game.playerELO
//
//      case None =>
//        player1Color.text = ""
//        player1Elo.text = ""
//        player1TotalMoves.text = ""
//        player1TotalTime.text = ""
//        player1MaterialGained.text = ""
//        player1MaterialLost.text = ""
//        player1OverallMaterial.text = ""
//
//        player2Color.text = ""
//        player2Elo.text = ""
//        player2TotalMoves.text = ""
//        player2TotalTime.text = ""
//        player2MaterialGained.text = ""
//        player2MaterialLost.text = ""
//        player2OverallMaterial.text = ""
//
//  //Load values
//  showGameOverview(None)
//
//  //Listen to change
//  gameHistoryTable.selectionModel().selectedItem.onChange(
//    (_,_, newValue) => showGameOverview(Option(newValue))
//  )

  def doBackTrack(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showEntryPoint()
  end doBackTrack
  

