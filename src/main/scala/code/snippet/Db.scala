package code.snippet

import sqltyped._
import shapeless._
import code.model.User

object Db {
  val myFirstname = 
    db withSession {
      sql("select firstname from users where lastname=?")apply(Some("Doe"))
    }

  def addGame(gameName: String) = 
    db withTransaction {
      sql("insert into games (creator_id, name) values (?,?)")apply(
        Some(User.currentUserId.get.toInt), Some(gameName))
    }

  def addTournament(gameId: Int, name: String, password: String) = {
    db withTransaction {
      sql("insert into tournaments (creator_id, game_id, name, password) values (?,?,?,?)")apply(
        Some(User.currentUserId.get.toInt), Some(gameId), Some(name), Some(password))
    }
  }

  def listGame = 
    db withSession {
      sql("select games.id, games.name, count(tourn_gameindex.tourn_id) as numOfTournament from games left join tourn_gameindex on games.id = tourn_gameindex.gameid group by games.id, games.name")apply()
    }

}