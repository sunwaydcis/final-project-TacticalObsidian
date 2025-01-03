package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import zn.makery.ChessTutor.ChessTutorApp
import scalafx.beans.property.{ReadOnlyObjectProperty, StringProperty}
import javafx.scene.control.{ComboBox, ToggleButton, ToggleGroup}
import scalafx.Includes.*
import scalafx.collections.ObservableBuffer
import zn.makery.ChessTutor.models.newGame

class GameOptions:

  @FXML private var colorRole: ToggleGroup = _
  @FXML private var gameTimeMode: ToggleGroup = _
//  @FXML private var aiELO_SelectionPane: ComboBox[Int] = null

  def initialize() =
//    aiELO_SelectionPane.setItems(ObservableBuffer(50, 100, 200))
//    aiELO_SelectionPane.getSelectionModel.select(2)

    colorRole.selectToggle(colorRole.toggles.get(1))
    gameTimeMode.selectToggle(gameTimeMode.toggles.get(1))

  //Properties and default values
  var playerColor = new StringProperty("Random")
  var gameTime = new StringProperty("Unlimited")
  var gameRules = Option[(StringProperty, StringProperty)](playerColor, gameTime)

  //Navigation functions
  @FXML private def doPlay_Test2(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showGame()
  end doPlay_Test2

  @FXML private def doPlay_Test(action: ActionEvent): Unit =
    gameRules match
      case Some(value) =>
        var timeCap1 = Option[Double](0.0)
        var timeCap2 = Option[Double](0.0)
        gameTime.value match
          case "Unlimited" =>
            timeCap1 = None
            timeCap2 = None
          case "10 | 10" =>
            timeCap1 = Some(600.00)
            timeCap2 = Some(600.00)
          case "10 | 5" =>
            timeCap1 = Some(600.00)
            timeCap2 = Some(300.00)
          case "5 | 10" =>
            timeCap1 = Some(300.00)
            timeCap2 = Some(600.00)
          case "5 | 5" =>
            timeCap1 = Some(300.00)
            timeCap2 = Some(300.00)

        println(s"Player color: ${playerColor.value}, Time cap1: $timeCap1, Time cap2: $timeCap2")

        val onClick =
          ChessTutorApp.newGame(playerColor.value, timeCap1, timeCap2, 100)
          ChessTutorApp.showGame()
      case None =>
        throw new Exception("Game Rules cannot be null!")

  @FXML private def doBackTrack(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showEntryPoint()
  end doBackTrack

  //Game mode buttons
  @FXML private def doSelectColorMode(action: ActionEvent): Unit =
    val onClick = {
      playerColor <== colorRole.selectedToggle.delegate.map(_.asInstanceOf[ToggleButton].text.value).orElse("Random")
      println(playerColor.value) //Debug code
    }

  //Game mode buttons
  @FXML private def doSelectTimeMode(action: ActionEvent): Unit =
    val onClick = {
      gameTime <== gameTimeMode.selectedToggle.delegate.map(_.asInstanceOf[ToggleButton].text.value).orElse("Unlimited")
      println(gameTime.value)
    }