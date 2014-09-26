package code.snippet

// import net.liftweb.http._
// import net.liftweb.util._

import net.liftweb._
import http._
import common._
import scala.xml._

class UploadScreen extends LiftScreen {
  override protected def hasUploadField = true
  var fName = "xx"
  val urlAfterSubmission = "/static/index"

  val name = field("Name", "", "placeholder" -> "Name of new game")
  val file = makeField[Array[Byte], Nothing]("File", new Array[Byte](0),
    field => SHtml.fileUpload(fph => {
      fName = fph.fileName
      field.set(fph.file) 
      }),NothingOtherValueInitializer)
  
  // override def finishButton = <button>Save</button>

  def finish() {
    S.notice("Thanks for uploading a file name of " + fName)
    S.notice("Thanks for uploading a game name of " + name)
    S.notice("Thanks for uploading a file of " + file.get.length + " bytes ")
    S.redirectTo(urlAfterSubmission)
  }
}
