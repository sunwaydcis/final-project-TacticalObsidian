package zn.makery.ChessTutor.view

import ChessTutor.models.Board
import javafx.event.ActionEvent
import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.control.{Label, TableColumn, TableView}
import javafx.scene.layout.AnchorPane
import scalafx.Includes.*
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import zn.makery.ChessTutor.ChessTutorApp
import zn.makery.ChessTutor.models.newGame

class GameViewController:
  @FXML private var moveHistoryTable: TableView[Any] = null
  @FXML private var playerTwoLabel: Label = null
  @FXML private var playerTwoElo: Label = null
  @FXML private var playerOneLabel: Label = null
  @FXML private var playerOneElo: Label = null
  @FXML private var boardContainer: AnchorPane = null

  def initialize(game: newGame) =
    boardContainer.getChildren.clear() //Clear
    // Create a new BoardView and add it to the container
    val boardView = new BoardView(game.board.get)
    boardContainer.getChildren.add(boardView)
  end initialize

  def doViewNext(action: ActionEvent): Unit =
    println("View Next clicked!")
    if moveHistoryTable.getItems.isEmpty then println("There are no moves!")

    else
      val currentIndex = moveHistoryTable.selectionModel().getSelectedIndex
      if currentIndex != -1 then
        println("Already at start of moves table!")
      else
        moveHistoryTable.getSelectionModel.select(currentIndex + 1)
        println("Load Next")

  def doViewPrevious(action: ActionEvent): Unit =
    println("View Prev clicked!")
    if moveHistoryTable.getItems.isEmpty then
      println("There are no moves!")

    else
      val currentIndex = moveHistoryTable.selectionModel().getSelectedIndex
      if currentIndex <= 0 then
        println("Already at start of moves table!")
      else
        moveHistoryTable.getSelectionModel.select(currentIndex - 1)
        println("Load Previous")

  def doGamePause(action: ActionEvent): Unit =
    println("Pause clicked!")

  def doGameResume(action: ActionEvent): Unit =
    println("Resume clicked!")

  def doSaveAndExit(action: ActionEvent): Unit =
    println("Save and Exit clicked!")
    exitGame()

  def doQuit(action: ActionEvent): Unit =
    println("Quit clicked!")
    exitGame()


  private def exitGame(): Unit =
    println("Game Exited Successfully!!")
    val onClick = ChessTutorApp.showGameSelect()


