package zn.makery.ChessTutor.view

import javafx.fxml.FXML
import javafx.event.ActionEvent
import scalafx.scene.control.{Label, TableView}
import zn.makery.ChessTutor.ChessTutorApp

class GameViewController:
  @FXML private var moveHistoryTable: TableView[Any] = _
  @FXML private var playerTwoLabel: Label = _
  @FXML private var playerTwoElo: Label = _
  @FXML private var playerOneLabel: Label = _
  @FXML private var playerOneElo: Label = _

  @FXML def doViewNext(action: ActionEvent): Unit =
    println("View Next clicked!")

  @FXML def doViewPrevious(action: ActionEvent): Unit =
    println("View Prev clicked!")

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

