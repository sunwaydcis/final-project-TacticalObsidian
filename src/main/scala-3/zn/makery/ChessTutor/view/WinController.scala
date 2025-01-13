package zn.makery.ChessTutor.view

import javafx.event.ActionEvent
import scalafx.stage.Stage
import zn.makery.ChessTutor.ChessTutorApp

class WinController():
  var dialogStage: Stage = null
  var outcome : String = null
  var okClicked = false
  
//  def outcome = __outcome
  
  def handleOk(action: ActionEvent): Unit =
    ChessTutorApp.game=null
    ChessTutorApp.outcome=null
    
  
