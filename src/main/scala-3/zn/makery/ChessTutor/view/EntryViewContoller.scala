package zn.makery.ChessTutor.view

import zn.makery.ChessTutor.LongLiveTheKingApp
import javafx.event.ActionEvent
/**
 * The EntryViewController class is responsible for managing the entry view
 * of the application and handling user interactions on this screen.
 *
 * This class serves as a controller for UI actions such as button clicks
 * within the entry view. It connects the view and the application logic.
 *
 * Methods:
 *   - handlePlayBtn: Invoked when the "Play" button is clicked. It transitions the user
 *     to the `GameSelectionView.fxml` of the application.
 *
 * Dependencies:
 *   - ActionEvent: Represents the event triggered by user interaction.
 *   - LLtK: The main application object which provides navigation and game state logic.
 */
class EntryViewContoller:
  def handlePlayBtn(action: ActionEvent): Unit = LongLiveTheKingApp.gameSelectionPane()
