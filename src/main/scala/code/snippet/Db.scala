package code.snippet

import sqltyped._
import shapeless._
import code.model.User

object Db {
  val myFirstname = 
    db withSession {
      sql("select firstname from users where lastname=?")apply(Some("doe"))
    }

  def addGame(gameName: String) = {
    db withTransaction {
      sql("insert into games (creator_id, name) values (?,?)")apply(
        Some(User.currentUserId.get.toInt), Some(gameName))
    }
  }

}