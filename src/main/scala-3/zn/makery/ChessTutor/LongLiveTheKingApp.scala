package zn.makery.ChessTutor

import ChessTutor.models.Board
import ChessTutor.models.chessPieces.Alliance
import javafx.fxml.FXMLLoader
import javafx.scene as jfxs
import javafx.scene.layout.AnchorPane
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.stage.{Modality, Stage}
import LongLiveTheKingApp.{getClass, stage}
import zn.makery.ChessTutor.models.Game
import zn.makery.ChessTutor.view.{HelpController, WinController}

/**
 * The `LongLiveTheKingApp`(LLtK) object serves as the main application for the LLtK application.
 * It initializes and manages the JavaFX stages and scenes and variables required for the application to run.
 * This code loads FXML layouts onto the main stage and provides utility methods to switch between different views.
 */
object LongLiveTheKingApp extends JFXApp3:
  private var _game: Game = _ /** game variable for game view*/
  private var _outcome: String = _ /**outcome variable for `WinView.fxml` pop up*/

  //Window root pane (src: Dr Chin Tek Min > Practicals)
  private var rootPane: Option[scalafx.scene.layout.BorderPane] = None
  override def start(): Unit =
    val rootResource = getClass.getResource("view/RootLayout.fxml")
    val loader = new FXMLLoader(rootResource)
    loader.load()
    
    //Set the stage
    rootPane = Option(loader.getRoot[jfxs.layout.BorderPane])
    stage = new PrimaryStage():
      title = "Long Live The King"
      scene = new Scene():
        root = rootPane.get

    //Load app entry point.
    entryPane() //I wanted to remove the (), but it makes it more clear that it's a method
  end start
  
  //Actions (Methods) for ChessTutorApp

  /** @group scene methods */
  /** Loads the child scenes onto the root layout.
   * @param resource //resource of the view file.
   * @param initializeController if the controller has a method, `initialize`, execute it (src: github copilot)
   * @tparam Controller //Controller of the class
   */
  private def childScene[Controller](resource: String, initializeController: Option[Controller => Unit] = None): Unit =
    val loader = new FXMLLoader(getClass.getResource(resource))
    loader.load()
    val controller = loader.getController[Controller]
    val rootPane = loader.getRoot[AnchorPane] //Anchor pane by default is the snap pane
    this.rootPane.get.center = rootPane
  
  //EntryView
  def entryPane(): Unit = childScene[zn.makery.ChessTutor.view.EntryViewContoller]("view/EntryView.fxml")

  //GameSelectView
  def gameSelectionPane(): Unit = childScene[zn.makery.ChessTutor.view.GameSelectController]("view/GameSelect.fxml")

  //GameView
  def gamePane(): Unit = childScene[zn.makery.ChessTutor.view.GameViewController]("view/GameView.fxml", Some(_.initialize))

  /**
   * Generates a new game instance with the given players and initializes the board.
   * @param whitePlayer the name of the player controlling the white pieces
   * @param blackPlayer the name of the player controlling the black pieces
   * @return Unit, as the function initializes the game but does not return a value
   */
  def generateGame(whitePlayer: String, blackPlayer: String): Unit =
    game = new Game(whitePlayer, blackPlayer, generateBoard)

  /**
   * Generates and initializes a new game board for `Game` class.
   * @return a fully initialized instance of the Board class.
   */
  private def generateBoard: Board =
    val board = new Board
    board.initialize()
    board
    
  def popUpDialog[Controller]()
  /**
   * Displays a dialog window to indicate the game over status and interacts with the controller.
   * @return a Boolean indicating whether the OK button was clicked (true) or not (false).
   */
  def winDialog(outcomeS: String, color: Option[Alliance]): Boolean =
    outcome = outcomeS
    val loader = new FXMLLoader(getClass.getResource("view/WinView.fxml"))
    loader.load()
    val roots2 = loader.getRoot[jfxs.Parent]
    val control = loader.getController[WinController]

    val dialog = new Stage():
      initModality(Modality.ApplicationModal)
      initOwner(stage)
      scene = new Scene:
        root = roots2

    control.dialogStage = dialog
    control.color = color
    control.outcome = outcome
    control.initialize
    dialog.showAndWait()
    control.okClicked
    
  def helpPane(): Boolean =
    val loader = new FXMLLoader(getClass.getResource("view/HelpView.fxml"))
    loader.load
    val roots2 = loader.getRoot[jfxs.Parent]
    val control = loader.getController[HelpController]
    
    val dialog = new Stage():
      initModality(Modality.ApplicationModal)
      initOwner(stage)
      scene = new Scene:
          root = roots2
  
    control.dialogStage = dialog
    dialog.showAndWait()
    control.okClicked
        
    
  /**
   * @return the current instance of the Game.
   */
  def game: Game = _game

  /**
   * Updates the game instance with a new game state.
   * @param newGame The new game to set as the current state.
   * @return Unit : sets the gameInstance variable `_game`
   */
  def game_=(newGame: Game): Unit =
    _game = newGame

  /**
   * Retrieves the outcome as a string. Used by `WinViewController`
   * @return the outcome represented as a string
   */
  def outcome: String = _outcome

  /**
   * Updates the outcome instance with a new outcome string.
   * @param newOutcome The new outcome string
   * @return Unit : sets the outcome variable `_outcome`
   */
  def outcome_=(newOutcome: String): Unit =
    _outcome = newOutcome

end LongLiveTheKingApp