package zn.makery.ChessTutor

import ChessTutor.models.Board
import javafx.fxml.FXMLLoader
import javafx.scene as jfxs
import javafx.scene.layout.AnchorPane
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.stage.{Modality, Stage}
import ChessTutorApp.{getClass, stage}
import zn.makery.ChessTutor.models.Game
import zn.makery.ChessTutor.view.WinController

object ChessTutorApp extends JFXApp3:
  private var _game: Game = _
  private var _outcome: String = _

  //Window root pane
  private var rootPane: Option[scalafx.scene.layout.BorderPane] = None

  override def start(): Unit =
    //Load root view
    val rootResource = getClass.getResource("view/RootLayout.fxml")
    val loader = new FXMLLoader(rootResource)
    loader.load()

    rootPane = Option(loader.getRoot[jfxs.layout.BorderPane])
    stage = new PrimaryStage():
      title = "ChessTutor"
      scene = new Scene():
        root = rootPane.get

    //Load app entry point.
    entryPane()

  end start

  //initializeController (Source: GitHub CoPilot)
  private def childScene[Controller](resource: String, initializeController: Option[Controller => Unit] = None): Unit =
    val loader = new FXMLLoader(getClass.getResource(resource))
    loader.load()
    val controller = loader.getController[Controller]
    val rootPane = loader.getRoot[AnchorPane]
    this.rootPane.get.center = rootPane

  //Actions (Methods) for ChessTutorApp
  def entryPane(): Unit = childScene[zn.makery.ChessTutor.view.EntryViewContoller]("view/EntryView.fxml")

  def gameSelectionPane(): Unit = childScene[zn.makery.ChessTutor.view.GameSelectController]("view/GameSelect.fxml")

  def gamePane(): Unit = childScene[zn.makery.ChessTutor.view.GameViewController]("view/GameView.fxml", Some(_.initialize))

  def generateGame(whitePlayer: String, blackPlayer: String): Unit =
    game = new Game(whitePlayer, blackPlayer, generateBoard)

  def winDialog(): Boolean =
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
    control.outcome = outcome
    dialog.showAndWait()
    control.okClicked
  
  def game: Game = _game

  def game_=(newGame: Game): Unit =
    _game = newGame

  def win(winnerName: String): Unit =
    outcome = winnerName

  def outcome: String = _outcome

  def outcome_=(newOutcome: String): Unit =
    _outcome = newOutcome

  private def generateBoard: Board =
    val board = new Board
    board.initialize
    board

end ChessTutorApp