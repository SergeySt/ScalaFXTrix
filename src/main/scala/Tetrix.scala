import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.{Scene, SceneAntialiasing}

object Tetrix extends JFXApp {
  stage = new PrimaryStage {
    title = "Tetrix"
    scene = new Scene(400, 700, true, SceneAntialiasing.Balanced)
  }
}
