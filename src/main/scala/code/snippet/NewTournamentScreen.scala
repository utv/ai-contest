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
import net.liftweb.util.Helpers._

class NewTournamentScreen extends LiftScreen {

  object id extends ScreenVar[Box[String]](Empty)
  override def localSetup() {
    id.set(S.param("id"))
    super.localSetup()
  }
  
  // Fields on LiftScreen
  val tournamentName = field("Name", "", "placeholder" -> "Name of new tournament")
  val passwd = password("Password", "", "placeholder" -> "Password for new tournament")
  // override def finishButton = <button>Save</button>


  def finish() {
    // addTournament(gameId: Int, name: String, password: String)
    val gameId = id openOr ""
    val urlAfterSubmission = appendParams("tournamentList", Seq("id" -> gameId))
    Db.addTournament(gameId.toInt, tournamentName, passwd)
    S.redirectTo(urlAfterSubmission)
  }
}
