package zn.makery.ChessTutor

import ChessTutor.models.{Board, Game}
import javafx.fxml.FXMLLoader
import javafx.scene as jfxs
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.stage.{Modality, Stage}
import zn.makery.ChessTutor.ChessTutorApp.{getClass, stage}
import zn.makery.ChessTutor.models.newGame
import zn.makery.ChessTutor.view.BoardView

import java.time.LocalDate

object ChessTutorApp extends JFXApp3:
  val gameHistoryData = new ObservableBuffer[Game]()
  var gameInstance: newGame = null

  //Window root pane
  private var rootPane: Option[scalafx.scene.layout.BorderPane] = None

  override def start(): Unit =
    //Test values
    gameHistoryData += new Game("White", 250, 300){
      outcome.value = "Checkmate"
    }
    gameHistoryData += new Game("White", 270, 320){
      datePlayed.value = LocalDate.of(2010, 8, 21)
      outcome.value = "Checkmate"
      totalTime.value = 560.00
    }
    gameHistoryData += new Game("Black", 220, 270){
      datePlayed.value = LocalDate.of(2080, 7, 12)
      outcome.value = "Checkmate"
    }
    gameHistoryData += new Game("White", 240, 290){
      datePlayed.value = LocalDate.of(2004, 2, 5)
      outcome.value = "Checkmate"
    }
    gameHistoryData += new Game("Black", 250, 300){
      datePlayed.value = LocalDate.of(1920, 1, 5)
      outcome.value = "Checkmate"
    }
    gameHistoryData += new Game("Black", 300, 300){
      datePlayed.value = LocalDate.of(1900, 12, 3)
      outcome.value = "Checkmate"
    }

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

  //Actions (Methods) for ChessTutorApp
  def showEntryPoint(): Unit =
    val resource = getClass.getResource("view/EntryView.fxml")
    val loader = new FXMLLoader(resource)
    val controller = loader.getController[zn.makery.ChessTutor.view.EntryViewContoller]
    loader.load()

    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane
  end showEntryPoint

  def showGameSelect(): Unit =
    val resource = getClass.getResource("view/GameSelect.fxml")
    val loader = new FXMLLoader(resource)
    val controller = loader.getController[zn.makery.ChessTutor.view.GameOptions]
    loader.load()

    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane
  end showGameSelect

  def showGameHistory(): Unit =
    val resource = getClass.getResource("view/GameHistory.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val controller = loader.getController[zn.makery.ChessTutor.view.GameHistoryController]
    controller.initialize()

    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane
  end showGameHistory

  def showGame(): Unit =
    val resource = getClass.getResource("view/GameView.fxml")
    val loader = new FXMLLoader(resource)
    val controller = loader.getController[zn.makery.ChessTutor.view.GameViewController]
    loader.load()
    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane

  end showGame

  def showAlert(): Unit = ???
  end showAlert

  def loadGameView(): Unit =
    val resource = getClass.getResource("view/GameView.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val controller = loader.getController[zn.makery.ChessTutor.view.GameViewController]
    controller.initialize(gameInstance)
    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane

  def generateGame(role: String, TC1: Option[Double], TC2: Option[Double], AIELO: Int): Unit =
    val game = new newGame(role, TC1, TC2, AIELO)
    game.board = Some(generateBoard())
    gameInstance = game

  private def generateBoard(): Board =
    val board = new Board()
    board.init()
    board

  //  def newGame(role: String, TC1: Option[Double], TC2: Option[Double], AIELO: Int): Unit =
  //    val board = generateBoard()
  //    val gameInstance = new newGame(role, TC1, TC2, AIELO)
  //    gameInstance.board = Some(board)
  //
  //    game += gameInstance
  //    println("New game created: " + game.foreach(_.toString))
  //    showGame()

  //      // Add ChessBoardView to the layout - Testing code
  //      val BoardView = new BoardView(board)
  //      this.rootPane.get.center = BoardView // Set the center of the BorderPane to the chess board view


end ChessTutorApp