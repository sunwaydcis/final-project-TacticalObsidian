package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import zn.makery.ChessTutor.LongLiveTheKingApp
import javafx.scene.control.TextField
import scalafx.Includes.*

class GameSelectController:

  @FXML private var whiteName: TextField = null
  @FXML private var blackName: TextField = null

  @FXML private def doPlay_Test(action: ActionEvent): Unit =
        LongLiveTheKingApp.generateGame(whiteName.text.value, blackName.text.value)
        LongLiveTheKingApp.gamePane()

  /**Return to main page 
   * @param action User clicks on the view
   * Dependencies 
   *  - LLtK - main app
   */
  @FXML private def doBackTrack(action: ActionEvent): Unit = LongLiveTheKingApp.entryPane()

