package zn.makery.ChessTutor.view

import ChessTutor.models.chessPieces.Alliance
import ChessTutor.models.chessPieces.Alliance.*
import javafx.event.ActionEvent
import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.control.{Label, TableColumn, TableView}
import javafx.scene.layout.{AnchorPane, VBox}
import scalafx.Includes.*
import scalafx.collections.ObservableBuffer
import zn.makery.ChessTutor.ChessTutorApp
import zn.makery.ChessTutor.models.{Game, Moves}

class GameViewController:
//  @FXML private var moveHistoryTable: TableView[Any] = null
//  @FXML private var playerTwoLabel: Label = null
//  @FXML private var playerTwoElo: Label = null
//  @FXML private var playerOneLabel: Label = null
//  @FXML private var playerOneElo: Label = null
  @FXML private var whitePlayer: Label = null
  @FXML private var whiteTakes: Label = null
//  @FXML private var WhiteCard: VBox = null
  @FXML private var blackPlayer: Label = null
  @FXML private var blackTakes: Label = null
//  @FXML private var blackCard: VBox = null
  @FXML private var movesTable: TableView[Moves] = null
  @FXML private var boardContainer: AnchorPane = null
  private var currentTurn: Alliance = White
  private var boardView: BoardView = _

  def initialize(game: Game) =
    movesTable.items = game.moves //Table
    whitePlayer.text = game.whiteName
    blackPlayer.text = game.blackName

    whiteTakes.text = ""
    blackTakes.text = ""


    boardContainer.getChildren.clear() //Clear
    // Create a new BoardView and add it to the container
    boardView = new BoardView(game.board)
    boardContainer.getChildren.add(boardView)
  end initialize

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


