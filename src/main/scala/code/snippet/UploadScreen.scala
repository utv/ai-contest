package code.snippet

import net.liftweb.http._
import net.liftweb.util._

// import net.liftweb._
// import http._
// import common._
// import scala.xml._

class UploadScreen extends LiftScreen {
  /*val from = field("E-mail", "", "placeholder" -> "Enter your e-mail")
  val subject = field("Subject", "", "placeholder" -> "Enter the subject of your message")
  val body = field("Message", "", "placeholder" -> "Enter your message")*/
  override protected def hasUploadField = true

  val name = field("Name", "", "placeholder" -> "Name of new game")
  val file = makeField[Array[Byte], Nothing]("File", new Array[Byte](0),
    field => SHtml.fileUpload(fph => field.set(fph.file)),NothingOtherValueInitializer)
  
  // override def finishButton = <button>Save</button>

  def finish() {
    S.notice("Thanks for uploading a file of " + file.get.length + " bytes ")
    
  }
}
