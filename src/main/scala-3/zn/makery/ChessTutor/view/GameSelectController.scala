

package zn.makery.ChessTutor.view

import ChessTutor.models.Game
import javafx.event.ActionEvent
import javafx.fxml.FXML
import scalafx.beans.property.{DoubleProperty, StringProperty}
import scalafx.scene.control.Button
import zn.makery.ChessTutor.ChessTutorApp

enum Role:
  case WHITE, BLACK, RANDOM

enum Burst:
  case UNLIMITED, STANDARD, BLITZ

enum Mode:
  case VsPlayer, VsBotEqual, VsBotEasy

class GameSelectController:
  /** CODE RESPONSIBILITY - Control the view logic
   * The outcome of certain views, can lead to the creation of a game instance object.
   */

  //WHY THIS APPROACH - WANT A BETTER WAY TO CONTROL VIEW STATE UPDATES.
  //MODE BUTTONS
  @FXML private var vsPlayer: Button = _
  @FXML private var vsBotEqual: Button = _
  @FXML private var vsBotEasy: Button = _

  //ROLE BUTTONS
  @FXML private var beWhite: Button = _
  @FXML private var beBlack: Button = _
  @FXML private var beRandom: Button = _

  //TIME BUTTONS
  @FXML private var beUnlimited: Button = _
  @FXML private var beStandard: Button = _
  @FXML private var beAdvantaged: Button = _
  @FXML private var beChallenged: Button = _
  @FXML private var beBlitz: Button = _
  @FXML private var play: Button = _
  @FXML private var back: Button = _

  //STYLING MONADS
  private var selectedModeButton: Option[Button] = Some(vsBotEasy)
  private var selectedRoleButton: Option[Button] = Some(beRandom)
  private var selectedTimeButton: Option[Button] = Some(beUnlimited)

  //PARAMETERS and DEFAULTS
  private var challenger: StringProperty = new StringProperty(this, "versus", Mode.VsBotEasy.toString)
  private var playerRole : StringProperty = new StringProperty(this, "playerRole", Role.RANDOM.toString)
  private var timeMode: StringProperty = new StringProperty(this, "timeMode", Burst.UNLIMITED.toString)
  private var player1TimeCap: DoubleProperty = new DoubleProperty()
  private var player2TimeCap: DoubleProperty = new DoubleProperty()

  //DO MODE SELECT
  private def challenger_=(button: Button): Unit =
    challenger = button.text
    println(challenger.value)

  //DO ROLE SELECT
  private def playRole_=(button: Button): Unit =
    playerRole = button.text
    println(playerRole.value)

  //DO TIME SELECT
  private def timeMode_=(button: Button): Unit =
    timeMode = button.text
    println(timeMode.value)
  //Code is repetitive, but it's more readable if each parameter was controlled. 


  //DO PLAY
  @FXML private def doPlay_Test(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showGame()
  end doPlay_Test

  // DO BACK
  @FXML private def doBackTrack(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showEntryPoint()
  end doBackTrack

  //STYLING METHODS
  def updateModeSelection(selectedButton: Button): Unit =
    selectedModeButton.foreach(_.getStyleClass.remove("selected"))
    selectedModeButton = Some(selectedButton)
    selectedButton.getStyleClass.add("selected")

  private def updateRoleSelection(selectedButton: Button): Unit =
    selectedRoleButton.foreach(_.getStyleClass.remove("selected"))
    selectedRoleButton = Some(selectedButton)
    selectedButton.getStyleClass.add("selected")

  private def updateTimeSelection(selectedButton: Button): Unit =
    selectedTimeButton.foreach(_.getStyleClass.remove("selected"))
    selectedTimeButton = Some(selectedButton)
    selectedButton.getStyleClass.add("selected")

  def doButtonRestyle(buttonGroup: Option[Button], selectedButton: Button): Unit = ???



  
