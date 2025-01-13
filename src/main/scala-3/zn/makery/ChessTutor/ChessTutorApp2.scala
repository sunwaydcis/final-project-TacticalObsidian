//package zn.makery.ChessTutor
//
//import ChessTutor.models.Board
//import javafx.fxml.FXMLLoader
//import javafx.scene as jfxs
//import javafx.scene.layout.AnchorPane
//import scalafx.Includes.*
//import scalafx.application.JFXApp3
//import scalafx.application.JFXApp3.PrimaryStage
//import scalafx.collections.ObservableBuffer
//import scalafx.scene.Scene
//import zn.makery.ChessTutor.ChessTutorApp.{getClass, stage}
//import zn.makery.ChessTutor.models.{Board2, Game}
//
//object ChessTutorApp2 extends JFXApp3:
//  val gameHistoryData = new ObservableBuffer[Game]()
//  private var gameInstance: Game = _
//  private var boardInstance: Board2 = _
//  
//  //Window root pane
//  private var rootPane: Option[scalafx.scene.layout.BorderPane] = None
//
//  override def start(): Unit =
//    //Load root view
//    val rootResource = getClass.getResource("view/RootLayout.fxml")
//    val loader = new FXMLLoader(rootResource)
//    loader.load()
//
//    rootPane = Option(loader.getRoot[jfxs.layout.BorderPane])
//    stage = new PrimaryStage():
//      title = "ChessTutor"
//      scene = new Scene():
//        root = rootPane.get
//
//    //Load app entry point.
//    showEntryPoint
//
//  end start
//
//  //initializeController (Source: GitHub CoPilot)
//  private def loadChildScenes[Controller](resource: String, initializeController: Option[Controller => Unit] = None): Unit =
//    val loader = new FXMLLoader(getClass.getResource(resource))
//    loader.load()
//    val controller = loader.getController[Controller]
//    val rootPane = loader.getRoot[AnchorPane]
//    this.rootPane.get.center = rootPane
//
//  //Actions (Methods) for ChessTutorApp
//  def showEntryPoint: Unit =
//    loadChildScenes[zn.makery.ChessTutor.view.EntryViewContoller]("view/EntryView.fxml")
//  end showEntryPoint
//
//  def showGameSelect: Unit =
//    loadChildScenes[zn.makery.ChessTutor.view.GameOptions]("view/GameSelect.fxml")
//  end showGameSelect
//
//  def showGameHistory: Unit =
//    loadChildScenes[zn.makery.ChessTutor.view.GameHistoryController]("view/GameHistory.fxml", Some(_.initialize()))
//  end showGameHistory
//
//  def loadGameView: Unit =
//    loadChildScenes[zn.makery.ChessTutor.view.GameViewController]("view/GameView2.fxml", Some(_.initialize(gameInstance)))
//    val resource = getClass.getResource("view/GameView2.fxml")
//    val loader = new FXMLLoader(resource)
//    loader.load()
//    val controller = loader.getController[zn.makery.ChessTutor.view.GameViewController2]
//    controller.initialize
//    val rootPane = loader.getRoot[jfxs.layout.AnchorPane]
//    this.rootPane.get.center = rootPane
//
//  def generateBoard: Unit =
//    boardInstance = new Board2
//
//end ChessTutorApp2