package code.snippet

import sqltyped._
import shapeless._

object Db {
	val myFirstname = 
    db withSession {
      sql("select firstname from users where lastname=?")apply(Some("Dee"))
    }
}