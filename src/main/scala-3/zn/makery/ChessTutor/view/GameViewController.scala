package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.control.{Label, TableColumn, TableView}
import javafx.scene.layout.AnchorPane
import scalafx.Includes.*
import zn.makery.ChessTutor.ChessTutorApp
import zn.makery.ChessTutor.models.newGame
import ChessTutor.models.chessPieces.Alliance
import ChessTutor.models.Board
import javafx.scene.layout.StackPane

class GameViewController:
  @FXML private var moveHistoryTable: TableView[Any] = null
  @FXML private var playerTwoLabel: Label = null
  @FXML private var playerTwoElo: Label = null
  @FXML private var playerOneLabel: Label = null
  @FXML private var playerOneElo: Label = null
  @FXML private var boardContainer: AnchorPane = null

  private var currentTurn: Alliance = Alliance.White
  private var boardView: BoardView = _

  def initialize(game: newGame) =
    boardContainer.children.clear() // Clear the container
    boardView = new BoardView(game.board.get)
    boardContainer.children.add(boardView)
    boardView.setHandleCellClick(handleCellClick)
    updateTurnDisplay()
  end initialize

  private def handleCellClick(row: Int, col: Int, cell: StackPane): Unit =
    val piece = boardView.board.piece(row, col)
    piece match
      case Some(p) if p.color == currentTurn =>
        // Handle piece selection and move logic
        boardView.updateBoard()
        // After making a move, switch turns
        switchTurn()
      case _ =>
        // Handle invalid move or empty cell click
        println("Invalid move or empty cell")

  private def switchTurn(): Unit =
    currentTurn = if currentTurn == Alliance.White then Alliance.Black else Alliance.White
    println(s"Turn switched to $currentTurn")
    updateTurnDisplay()

  private def updateTurnDisplay(): Unit =
    currentTurn match
      case Alliance.White => playerOneLabel.setText("White's turn")
      case Alliance.Black => playerTwoLabel.setText("Black's turn")

  def doViewNext(action: ActionEvent): Unit =
    println("View Next clicked!")
    if moveHistoryTable.getItems.isEmpty then println("There are no moves!")
    else
      val currentIndex = moveHistoryTable.selectionModel().getSelectedIndex
      if currentIndex != -1 then
        println("Already at start of moves table!")
      else
        moveHistoryTable.getSelectionModel.select(currentIndex + 1)
        println("Load Next")

  def doViewPrevious(action: ActionEvent): Unit =
    println("View Prev clicked!")
    if moveHistoryTable.getItems.isEmpty then
      println("There are no moves!")
    else
      val currentIndex = moveHistoryTable.selectionModel().getSelectedIndex
      if currentIndex <= 0 then
        println("Already at start of moves table!")
      else
        moveHistoryTable.getSelectionModel.select(currentIndex - 1)
        println("Load Previous")

  def doGamePause(action: ActionEvent): Unit =
    println("Pause clicked!")

  def doGameResume(action: ActionEvent): Unit =
    println("Resume clicked!")

  def doSaveAndExit(action: ActionEvent): Unit =
    println("Save and Exit clicked!")
    exitGame()

  def doQuit(action: ActionEvent): Unit =
    println("Quit clicked!")
    exitGame()

  private def exitGame(): Unit =
    println("Game Exited Successfully!!")
    val onClick = ChessTutorApp.showGameSelect()