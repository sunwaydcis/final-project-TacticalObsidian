//package zn.makery.ChessTutor.view
//
//import ChessTutor.models.chessPieces.Alliance
//import ChessTutor.models.chessPieces.Alliance.*
//import javafx.event.ActionEvent
//import javafx.fxml.{FXML, FXMLLoader}
//import javafx.scene.control.{Label, TableColumn, TableView}
//import javafx.scene.layout.{GridPane, VBox}
//import scalafx.Includes.*
//import scalafx.beans.property.StringProperty
//import scalafx.scene.layout.StackPane
//import scalafx.collections.ObservableBuffer
//import zn.makery.ChessTutor.ChessTutorApp
//import zn.makery.ChessTutor.models.{Board2, Game, Moves}
//
//class GameViewController2:
//  @FXML private var whitePlayer: Label = null
//  @FXML private var whiteTakes: Label = null
//  @FXML private var blackPlayer: Label = null
//  @FXML private var blackTakes: Label = null
//  @FXML private var movesTable: TableView[Moves] = null
//  @FXML private var moves: TableColumn[Moves, String] = null
//  @FXML private var boardContainer: GridPane = null
//  private var currentTurn: Alliance = White
//  private var board: Board2 = null
//
//  def initialize =
//    movesTable.items = board.moves
//    for (child <- boardContainer.children) do
//      val cell = new StackPane
//      val tile = new Rectangle:
//        fill = if (GridPane.rowIndex(child) + GridPane.setColumnIndex(child)) %2 == 0 then Beige else SaddleBrown
//      child.onMouseClicked = _ => {
//
//      }
//      for (piece <- board.board) do
//
//
//  end initialize
//
//  def doGamePause(action: ActionEvent): Unit =
//    println("Pause clicked!")
//
//  def doGameResume(action: ActionEvent): Unit =
//    println("Resume clicked!")
//
//  def doSaveAndExit(action: ActionEvent): Unit =
//    println("Save and Exit clicked!")
//    exitGame()
//
//  def doQuit(action: ActionEvent): Unit =
//    println("Quit clicked!")
//    exitGame()
//
//  private def exitGame(): Unit =
//    println("Game Exited Successfully!!")
//    val onClick = ChessTutorApp.showGameSelect()
//
//
