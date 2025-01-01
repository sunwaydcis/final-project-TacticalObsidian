package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import scalafx.beans.property.{DoubleProperty, IntegerProperty, StringProperty}
import zn.makery.ChessTutor.ChessTutorApp
import scalafx.scene.control.{ToggleButton, ToggleGroup}

enum Role:
  case WHITE, BLACK, RANDOM

enum Burst:
  case UNLIMITED, STANDARD, BLITZ

enum Mode:
  case VsPlayer, VsBotEqual, VsBotEasy

class GameSelectController():
  /** CODE RESPONSIBILITY - Control the view logic
   * The outcome of certain views, can lead to the creation of a game instance object.
   */

  private var gameRole : StringProperty = new StringProperty()
  private var playerMaxTime: DoubleProperty = new DoubleProperty()
  private var botMaxTime: DoubleProperty = new DoubleProperty()
  private var challenger: StringProperty = new StringProperty()
  private var botEloAppend: IntegerProperty = new IntegerProperty()


  private def doPlay_Test(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showGame()
  end doPlay_Test

  private def doBackTrack(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showEntryPoint()
  end doBackTrack



//  //Role changers
//  private def startWhite(action: ActionEvent): Unit = ???
//  private def startBlack(action: ActionEvent): Unit = ???
//  private def startRandom(action: ActionEvent): Unit = ???
//
//  //Time changers
//  private def beUnlimited(action: ActionEvent): Unit = ???
//  private def beStandard(action: ActionEvent): Unit = ???
//  private def beSeige(action: ActionEvent): Unit = ???
//  private def beSeiged(action: ActionEvent): Unit = ???
//  private def beBlitz(action: ActionEvent): Unit = ???