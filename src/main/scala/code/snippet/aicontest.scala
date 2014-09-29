package code.snippet

import scala.slick.session.Database
import sqltyped._

package object aicontest {
  Class.forName("org.postgresql.Driver")
  val db = Database.forURL("jdbc:postgresql://localhost:5432/ai", 
    driver = "org.postgresql.Driver", user = "ai", password = "ai")
  implicit val conn = Database.threadLocalSession.conn
}