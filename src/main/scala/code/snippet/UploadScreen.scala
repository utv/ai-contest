package code.snippet

import net.liftweb.http._

class UploadScreen extends LiftScreen {
  val from = field("E-mail", "", "placeholder" -> "Enter your e-mail")
  val subject = field("Subject", "", "placeholder" -> "Enter the subject of your message")
  val body = field("Message", "", "placeholder" -> "Enter your message")

  override def finishButton = <button>Save</button>

  protected def finish() {
    S.notice("form submitted")
    
  }
}
