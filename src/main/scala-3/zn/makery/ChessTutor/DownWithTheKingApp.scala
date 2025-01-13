package zn.makery.ChessTutor

import ChessTutor.models.Board
import javafx.fxml.FXMLLoader
import javafx.scene as jfxs
import javafx.scene.layout.AnchorPane
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import zn.makery.ChessTutor.models.Game

object DownWithTheKingApp extends JFXApp3:
  private var _game: Game = _

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
    entryView

  end start

  private def loadChildScenes[Controller](resource: String, initializeController: Option[Controller => Unit] = None): Unit =
    val loader = new FXMLLoader(getClass.getResource(resource))
    loader.load()
    val controller = loader.getController[Controller]
    val rootPane = loader.getRoot[AnchorPane]
    this.rootPane.get.center = rootPane

  //Actions (Methods) for ChessTutorApp
  def entryView =
    loadChildScenes[zn.makery.ChessTutor.view.EntryViewContoller]("view/EntryView.fxml")
  end entryView

  def gameOptions =
    loadChildScenes[zn.makery.ChessTutor.view.GameOptions]("view/GameSelect.fxml")
  end gameOptions

  def gameView =
    loadChildScenes[zn.makery.ChessTutor.view.GameViewController]("view/GameView.fxml", Some(_.initialize))

  def generateGame(whitePlayer: String, blackPlayer: String): Unit =
    val instanceGame = new Game(whitePlayer, blackPlayer, generateBoard)
    game = instanceGame

  def game =
    _game

  def game_=(newGame: Game)=
    _game = newGame

  private def generateBoard: Board =
    val board = new Board
    board.init
    board

end DownWithTheKingApp