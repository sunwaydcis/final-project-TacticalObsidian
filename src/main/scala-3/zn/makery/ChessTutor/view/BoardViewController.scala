package zn.makery.ChessTutor.view

import ChessTutor.models.Board
import javafx.event.EventHandler
import scalafx.scene.input.MouseEvent
import scalafx.scene.text.Text

class BoardViewController(board: Board, boardView: BoardView):
  def initialze() =
    boardView.children.foreach {
      case cell: Text =>
    }

  boardView.initialize()

