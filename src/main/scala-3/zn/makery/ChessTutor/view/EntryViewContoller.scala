package zn.makery.ChessTutor.view

import zn.makery.ChessTutor.ChessTutorApp
import javafx.event.ActionEvent
import javafx.fxml.FXML

/**
 * Not too proud of this being very small.
 */

class EntryViewContoller:
  @FXML private def handlePlayBtn(action: ActionEvent): Unit = ChessTutorApp.gameSelectionPane()
