package zn.makery.ChessTutor

import javafx.fxml.FXMLLoader
import javafx.scene as jfxs
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.stage.{Modality, Stage}
import zn.makery.ChessTutor.ChessTutorApp.{getClass, stage}

object ChessTutorApp extends JFXApp3:

  //Window root pane
  var rootPane: Option[scalafx.scene.layout.BorderPane] = None

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
    val controller = loader.getController[zn.makery.ChessTutor.view.GameSelectController]
    loader.load()

    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
    this.rootPane.get.center = rootPane
  end showGameSelect

  def showGameHistory(): Unit =
    val resource = getClass.getResource("view/GameHistory.fxml")
    val loader = new FXMLLoader(resource)
    val controller = loader.getController[zn.makery.ChessTutor.view.GameHistoryController]
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