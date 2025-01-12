package zn.makery.ChessTutor

import ChessTutor.models.{Board, Game}
import javafx.fxml.FXMLLoader
import javafx.scene as jfxs
import javafx.scene.layout.AnchorPane
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import zn.makery.ChessTutor.ChessTutorApp.{getClass, stage}
import zn.makery.ChessTutor.models.newGame

import java.time.LocalDate

object ChessTutorApp extends JFXApp3:
  val gameHistoryData = new ObservableBuffer[Game]()
  private var gameInstance: newGame = _

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
    showEntryPoint()

  end start

  //initializeController (Source: GitHub CoPilot)
  private def loadChildScenes[Controller](resource: String, initializeController: Option[Controller => Unit] = None): Unit =
    val loader = new FXMLLoader(getClass.getResource(resource))
    loader.load()
    val controller = loader.getController[Controller]
    val rootPane = loader.getRoot[AnchorPane]
    this.rootPane.get.center = rootPane

  //Actions (Methods) for ChessTutorApp
  def showEntryPoint(): Unit =
    loadChildScenes[zn.makery.ChessTutor.view.EntryViewContoller]("view/EntryView.fxml")
  end showEntryPoint

  def showGameSelect(): Unit =
    loadChildScenes[zn.makery.ChessTutor.view.GameOptions]("view/GameSelect.fxml")
  end showGameSelect

  def showGameHistory(): Unit =
    loadChildScenes[zn.makery.ChessTutor.view.GameHistoryController]("view/GameHistory.fxml", Some(_.initialize()))
  end showGameHistory

  def loadGameView(): Unit =
    loadChildScenes[zn.makery.ChessTutor.view.GameViewController]("view/GameView.fxml", Some(_.initialize(gameInstance)))
    val resource = getClass.getResource("view/GameView.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val controller = loader.getController[zn.makery.ChessTutor.view.GameViewController]
    controller.initialize(gameInstance)
    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane

  def generateGame(role: String): Unit =
    val game = new newGame(role)
    game.board = Some(generateBoard())
    gameInstance = game

  def showAlert(): Unit = ???
  end showAlert

  private def generateBoard(): Board =
    val board = new Board()
    board.init()
    board

  def loadTestValueHistory(): Unit =
    //Test values
    gameHistoryData += new Game("White", 250, 300) {
      outcome.value = "Checkmate"
    }

    gameHistoryData += new Game("White", 270, 320) {
      datePlayed.value = LocalDate.of(2010, 8, 21)
      outcome.value = "Checkmate"
      totalTime.value = 560.00
    }
    gameHistoryData += new Game("Black", 220, 270) {
      datePlayed.value = LocalDate.of(2080, 7, 12)
      outcome.value = "Checkmate"
    }
    gameHistoryData += new Game("White", 240, 290) {
      datePlayed.value = LocalDate.of(2004, 2, 5)
      outcome.value = "Checkmate"
    }
    gameHistoryData += new Game("Black", 250, 300) {
      datePlayed.value = LocalDate.of(1920, 1, 5)
      outcome.value = "Checkmate"
    }
    gameHistoryData += new Game("Black", 300, 300) {
      datePlayed.value = LocalDate.of(1900, 12, 3)
      outcome.value = "Checkmate"
    }

end ChessTutorApp