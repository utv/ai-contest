package code
import scala.slick.session.Database
import sqltyped._

package object snippet {
	Class.forName("org.postgresql.Driver")
  val db = Database.forURL("jdbc:postgresql://localhost:5432/ai",
    driver = "org.postgresql.Driver", user = "ai", password = "ai")
  
  implicit def conn = Database.threadLocalSession.conn	
}
