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
import zn.makery.ChessTutor.LongLiveTheKingApp
import zn.makery.ChessTutor.models.{Game, Moves}

/**
 * GameViewController is responsible for managing and controlling the game UI components,
 * including the display of player names, moves, and the chessboard.
 *
 * It initializes the game state and updates the UI elements to reflect the current game configuration.
 * The class interacts with other components of the application to handle user actions and game state changes.
 */
class GameViewController: //(GVC)
  /**
   * UI elements used by the GVC
   */
  @FXML private var whitePlayer: Label = null /**White player name from `GameSelectController` */
  @FXML private var blackPlayer: Label = null /**Black player name from `GameSelectController` */
  @FXML private var movesTable: TableView[Moves] = null /**Table view to display type `Moves` {zn.makery.ChessTutor.models.Moves} */
  @FXML private var moves: TableColumn[Moves, String] = null
  @FXML private var boardContainer: AnchorPane = null
  private var boardView: BoardView = null
  private var game : Game = null

  /**
   * Initializes the game UI components with the current game state.
   * Sets up the moves table, players' names, and board view.
   * Resets the board container and recreates the board view.
   * @return Unit, as this method modifies the UI components and does not return a value.
   */
  def initialize: Unit =
    game = LongLiveTheKingApp.game
    movesTable.items = game.moves //Table
    moves.cellValueFactory = cellData => new StringProperty(cellData.value.move)
    whitePlayer.text = game.whiteName
    blackPlayer.text = game.blackName
    boardContainer.children.clear //Clear (Suggestion By Github Copilot)  
    boardView = new BoardView(game) // Create a new BoardView and add it to the container (Suggestion By Github Copilot)  
    boardContainer.children.add(boardView)
  end initialize

  /**
   * Handles the quit action triggered by the user.
   * @param action the ActionEvent triggered by the user interaction
   * @return Unit, no value is returned from this method
   */
  @FXML private def doQuit(action: ActionEvent): Unit = LongLiveTheKingApp.gameSelectionPane()


