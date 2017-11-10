import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene._
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.shape.Rectangle

object Tetrix extends JFXApp {
  stage = new PrimaryStage {
    title = "Tetrix"
    val canvas = new Canvas(400, 700)
    val gc: GraphicsContext = canvas.graphicsContext2D

    for (i <- 20 to 400 by 40) {
      gc.strokeLine(i, 10, i, 690)
    }

    for (i <- 10 to 700 by 40) {
      gc.strokeLine(20, i, 380, i)
    }

    val rectangle = Rectangle(20,10,40,40)

    var group: Group = new Group {
      children = List(canvas,rectangle)


    }

    scene = new Scene {
      content = Seq(group)
      onKeyPressed = (k: KeyEvent) => k.code match {
        case KeyCode.Down if (rectangle.y < 650).get => rectangle.y = rectangle.y.value + 40
        case KeyCode.Right if (rectangle.x < 340).get => rectangle.x= rectangle.x.value + 40
        case KeyCode.Left if (rectangle.x > 20).get => rectangle.x = rectangle.x.value - 40
        case _ =>
      }
    }

  }
}
