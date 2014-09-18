package code.snippet

import java.io.{File,FileOutputStream}

import net.liftweb.http.S
import net.liftweb.util._
import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml._
import net.liftweb.http.FileParamHolder
import net.liftweb.common.{Loggable, Full, Empty, Box}
import net.lingala.zip4j.exception.ZipException
import net.lingala.zip4j.core.ZipFile

class FileUploadSnippet extends Loggable {
  // val filePath = "src/main/webapp/images"
  // val filePath = "scala210/games"
  val filePath = "games"

  def render = {
    var upload : Box[FileParamHolder] = Empty

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

    def processForm() = upload match {
      case Full(FileParamHolder(_, mimeType, fileName, file)) =>
        logger.info("%s of type %s is %d bytes long" format (fileName, mimeType, file.length) )
        val oFile = new File(filePath, fileName)
        val output = new FileOutputStream(oFile)
        output.write(file)
        output.close()
        unzipFile(oFile.getAbsolutePath())
        logger.info("File uploaded!")
        S.notice("Thanks for the upload")
      case _ => logger.warn("No file?")
    }
    
    "#file" #> fileUpload(f => upload = Full(f)) &
    "type=submit" #> onSubmitUnit(processForm)
  }
}
