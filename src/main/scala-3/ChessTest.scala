import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle



object ChessBoardApp extends JFXApp3 {

  override def start(): Unit = {
    // Create the main board
    val board = new GridPane

    // Define cell size
    val cellSize = 60

    // Create the 8x8 board with alternating colors
    for (row <- 0 until 8; col <- 0 until 8) {
      val cellColor = if ((row + col) % 2 == 0) Color.White else Color.Black
      val cell = new Rectangle {
        width = cellSize
        height = cellSize
        fill = cellColor
      }
      board.add(cell, col, row) // Add cell to the grid at (col, row)
    }

    // Set up the scene
    stage = new JFXApp3.PrimaryStage {
      title = "Chess Board"
      scene = new Scene {
        content = board
      }
    }
  }
}
