package zn.makery.ChessTutor

import javafx.fxml.FXMLLoader
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes.*
import javafx.scene as jfxs
import scalafx.collections.ObservableBuffer
import scalafx.stage.{Modality, Stage}

object ChessTutorApp extends JFXApp3:

  //Window root pane
  var rootPane: Option[scalafx.scene.layout.BorderPane] = None

  override def start(): Unit =
    val rootResource = getClass.getResource("view/RootLayout.fxml")
    val loader = new FXMLLoader(rootResource)
    loader.load()

    rootPane = Option(loader.getRoot[jfxs.layout.BorderPane])
    stage = new PrimaryStage():
      title = "ChessTutor"
      scene = new Scene():
        root = rootPane.get

    //For testing purposes show the game
//    showGameHistory()
//    showEntryPoint()
//    showGameSetting()
//    showGame()

  end start

  //Actions (Methods) for ChessTutorApp
  def showEntryPoint(): Unit =
    val resource = getClass.getResource("view/EntryView.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()

    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane
  end showEntryPoint

  def showGameSetting(): Unit =
    val resource = getClass.getResource("view/BotSelectView.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()

    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane
  end showGameSetting

  def showGameHistory(): Unit =
    val resource = getClass.getResource("view/GameHistory.fxml")

    val loader = new FXMLLoader(resource)
    loader.load()

    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane
  end showGameHistory

  def showGame(): Unit =
    val resource = getClass.getResource("view/GameView.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()

    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane

  end showGame

  def showAlert(): Unit = ???
  end showAlert

end ChessTutorApp