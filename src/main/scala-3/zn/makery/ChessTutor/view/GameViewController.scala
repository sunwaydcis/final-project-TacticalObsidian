package zn.makery.ChessTutor.view

import ChessTutor.models.chessPieces.Alliance
import ChessTutor.models.chessPieces.Alliance.*
import javafx.event.ActionEvent
import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.control.{Label, TableColumn, TableView}
import javafx.scene.layout.{AnchorPane, VBox}
import scalafx.Includes.*
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import zn.makery.ChessTutor.DownWithTheKingApp
import zn.makery.ChessTutor.models.{Game, Moves}

class GameViewController:
//  @FXML private var moveHistoryTable: TableView[Any] = null
//  @FXML private var playerTwoLabel: Label = null
//  @FXML private var playerTwoElo: Label = null
//  @FXML private var playerOneLabel: Label = null
//  @FXML private var playerOneElo: Label = null
  @FXML private var whitePlayer: Label = null
  @FXML private var blackPlayer: Label = null
  @FXML private var movesTable: TableView[Moves] = null
  @FXML private var moves: TableColumn[Moves, String] = null
  @FXML private var boardContainer: AnchorPane = null
  private var currentTurn: Alliance = White
  private var boardView: BoardView = _

  def initialize =
    val game = DownWithTheKingApp.game
    movesTable.items = game.moves //Table
    moves.cellValueFactory =
      (cellData => new StringProperty(cellData.value.move))

    whitePlayer.text = game.whiteName
    blackPlayer.text = game.blackName
    
    boardContainer.children.clear //Clear
    // Create a new BoardView and add it to the container
    boardView = new BoardView(game)
    boardContainer.children.add(boardView)
  end initialize

  
  def doQuit(action: ActionEvent): Unit = DownWithTheKingApp.gameOptions

