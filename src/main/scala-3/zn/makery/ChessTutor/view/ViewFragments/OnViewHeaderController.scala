package zn.makery.ChessTutor.view.ViewFragments

import javafx.event.ActionEvent
import zn.makery.ChessTutor.ChessTutorApp

class OnViewHeaderController():
  def handleBackBtn(action: ActionEvent): Unit =
    val onClick = ChessTutorApp.showEntryPoint()

//For now, I will keep this unconnected to the main code.
//Nvm, a new approach is taken: Update the root menu buttons.