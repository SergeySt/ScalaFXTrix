import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene._
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.shape.Rectangle
import scalafx.scene.paint.{Color}

object Tetrix extends JFXApp {

  case class EmptyRectangle(width: Int, height: Int)

  stage = new PrimaryStage {
    title = "Tetrix"
    val canvas = new Canvas(400, 700)
    val gc: GraphicsContext = canvas.graphicsContext2D

    val blockSize:(Int, Int) = (40,40)

    val rectangle = Rectangle(0, 1, blockSize._1, blockSize._2)

    var groupNet: Group = new Group {
      for {
        x_pos <- 0 to 400 by blockSize._1 + 1
        y_pos <- 1 to 680 by blockSize._2 + 1
        rec =  new Rectangle {
          x = x_pos
          y = y_pos
          width = blockSize._1
          height = blockSize._2
          fill = Color.LightBlue
        }
      } children.add(rec)
    }


    var group: Group = new Group {
      children = List(canvas,groupNet, rectangle)


    }

    scene = new Scene {
      content = Seq(group)
      onKeyPressed = (k: KeyEvent) => k.code match {
        case KeyCode.Down if (rectangle.y < 650).get => rectangle.y = rectangle.y.value + blockSize._2 + 1
        case KeyCode.Right if (rectangle.x < 340).get => rectangle.x= rectangle.x.value + blockSize._1 + 1
        case KeyCode.Left if (rectangle.x > 20).get => rectangle.x = rectangle.x.value - blockSize._1 - 1
        case _ =>
      }
    }

  }
}
