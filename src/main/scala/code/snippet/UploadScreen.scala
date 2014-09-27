package code.snippet

// import net.liftweb.http._
// import net.liftweb.util._
import java.io.{File, FileOutputStream}

import net.liftweb._
import http._
import common._
import scala.xml._

class UploadScreen extends LiftScreen {
  override protected def hasUploadField = true
  
  var upload : Box[FileParamHolder] = Empty
  val urlAfterSubmission = "/static/index"
  val filePath = "games"
  
  // Fields on LiftScreen
  val name = field("Name", "", "placeholder" -> "Name of new game")
  val file = makeField[Array[Byte], Nothing]("File", new Array[Byte](0),
    field => SHtml.fileUpload(fph => upload = Full(fph)),NothingOtherValueInitializer)
  
  // override def finishButton = <button>Save</button>

  def processUpload() = upload match {
    case Full(FileParamHolder(_, mimeType, fileName, file)) => 
      val oFile = new File(filePath, fileName)
      val output = new FileOutputStream(oFile)
      output.write(file)
      output.close()
    case _ => println("No file?")
  }

  def finish() {
    processUpload
    S.redirectTo(urlAfterSubmission)
  }
}
