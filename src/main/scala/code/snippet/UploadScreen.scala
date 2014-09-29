package code.snippet

// import net.liftweb.http._
// import net.liftweb.util._
import java.io.{File, FileOutputStream}

import net.liftweb._
import http._
import common._
import scala.xml._
import net.lingala.zip4j.exception.ZipException
import net.lingala.zip4j.core.ZipFile

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

  def unzipFile(source: String) = {
    // val source = "src/main/webapp/images/test.zip"
    // val destination = "games"
    try { 
      val zipFile = new ZipFile(source);
      zipFile.extractAll(filePath);
    } catch {
      case e: Exception => "Unable to unzip!!"
    }
  }

  def processUpload() = upload match {
    case Full(FileParamHolder(_, mimeType, fileName, file)) => 
      val oFile = new File(filePath, fileName)
      val output = new FileOutputStream(oFile)
      output.write(file)
      output.close()
      unzipFile(oFile.getAbsolutePath())
      
      S.notice("Thanks for the upload")
    case _ => println("No file?")
  }

  def finish() {
    processUpload
    S.redirectTo(urlAfterSubmission)
  }
}
