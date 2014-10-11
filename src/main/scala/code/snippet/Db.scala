package code.snippet

import sqltyped._
import shapeless._
import code.model.User

object Db {
  val myFirstname = 
    db withSession {
      sql("select firstname from users where lastname=?")apply(Some("doe"))
    }

  def addGame(gameName: String) = 
    db withTransaction {
      sql("insert into games (creator_id, name) values (?,?)")apply(
        Some(User.currentUserId.get.toInt), Some(gameName))
    }

  def listGame = 
    db withSession {
      sql("select games.name, count(tourn_gameindex.tourn_id) " +
        "from games left join tourn_gameindex on games.id = tourn_gameindex.gameid group by games.name")
    }

}