package code.snippet

import java.io.{File, FileOutputStream}
import net.liftweb._
import http._
import common._
import scala.xml._
import net.lingala.zip4j.exception.ZipException
import net.lingala.zip4j.core.ZipFile
import net.liftweb.util.Helpers._

class NewBot extends LiftScreen {
  override protected def hasUploadField = true

  // This is how we pass param "id" to LIftScreen and stored in "id" object
  object id extends ScreenVar[Box[String]](Empty)
  override def localSetup() {
    id.set(S.param("tourn_id"))
    super.localSetup()
  }

  var upload : Box[FileParamHolder] = Empty  
  // Fields on LiftScreen
  val botName = field("Name", "", "placeholder" -> "")
  val uploadFile = makeField[Array[Byte], Nothing]("File", new Array[Byte](0),
    field => SHtml.fileUpload(fph => upload = Full(fph)), NothingOtherValueInitializer)

  def processUpload(tournamentId: String) = upload match {
    case Full(FileParamHolder(_, mimeType, fileName, file)) => 
      val botDir = "bots"
      try { 
        val oFile = new File(botDir, fileName)
        val output = new FileOutputStream(oFile)
        output.write(file)
        output.close()
        
        // unzipFile(oFile.getAbsolutePath(), gameDir)
        Db.addBot(tournamentId.toInt, botName)

      } catch {
        case e: Exception => e.printStackTrace; println(e)
      }
      S.notice("Thanks for the upload")
    case _ => println("No file?")
  }

  def finish() {
    val tournamentId = id openOr ""
    processUpload(tournamentId)
    S.redirectTo(appendParams("tournament", Seq("tourn_id" -> tournamentId)))
  }
}
