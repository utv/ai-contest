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

  def addBot(tournamentId: Int,botName: String) = 
    db withTransaction {
      sql("insert into bots (owner_id, name) values (?,?)")apply(
        Some(User.currentUserId.get.toInt), Some(botName))
      
      val botId = sql("select max(id) from bots")apply()
      sql("insert into tourn_bots (tourn_id, bot_id) values (?,?)")apply(
        Some(tournamentId), botId)
    }
  
  def addTournament(gameId: Int, name: String, password: String) = 
    db withTransaction {
      sql("insert into tournaments (creator_id, game_id, name, password, start_date) values (?,?,?,?,current_timestamp)")apply(
        Some(User.currentUserId.get.toInt), Some(gameId), Some(name), Some(password))
      
      val tournId = sql("select max(id) from tournaments")apply()
      sql("insert into tourn_gameindex (tourn_id, gameid) values (?,?)")apply(tournId, Some(gameId))
    }

  def listGame = 
    db withSession {
      sql("select games.id as game_id, games.name, count(tourn_gameindex.tourn_id) as numOfTournament " 
        + "from games left join tourn_gameindex on games.id = tourn_gameindex.gameid "
        + "group by games.id, games.name")apply()
    }

  def listTournament(gameId: Int) = 
    db withSession {
      sql("select tournaments.id as tourn_id, tournaments.name as tournament_name, users.firstname as creator "
        + "from users, tournaments where tournaments.creator_id = users.id and tournaments.game_id=?")apply(Some(gameId))
    }

  def leaderBoard(tournamentId: Int) = {
    db withSession {
      sql("select tourn_bots.rank as rank, bots.name as bot_name from tourn_bots, bots "
        + "where tourn_bots.bot_id = bots.id and tourn_bots.tourn_id=?")apply(Some(tournamentId))
    }
  }

}