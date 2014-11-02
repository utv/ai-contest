package code.snippet

import java.io.{File, FileOutputStream}
import net.liftweb._
import http._
import common._
import scala.xml._
import net.lingala.zip4j.exception.ZipException
import net.lingala.zip4j.core.ZipFile
import net.liftweb.util.Helpers._

class NewTournamentScreen extends LiftScreen {

  // This is how we pass param "id" to LIftScreen and stored in "id" object
  object id extends ScreenVar[Box[String]](Empty)
  override def localSetup() {
    id.set(S.param("id"))
    super.localSetup()
  }
  
  // Fields on LiftScreen
  val tournamentName = field("Name", "", "placeholder" -> "")
  val passwd = password("Password", "", "placeholder" -> "")
  // override def finishButton = <button>Save</button>

  def finish() {
      val gameId = id openOr ""
      // addTournament(gameId: Int, name: String, password: String)
      Db.addTournament(gameId.toInt, tournamentName, passwd)
      S.redirectTo(appendParams("tournamentList", Seq("id" -> gameId)))
  }
}
