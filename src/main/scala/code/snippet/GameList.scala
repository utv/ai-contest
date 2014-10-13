package code.snippet

import net.liftweb.util.Helpers._
import net.liftweb.mapper._

class GameList {

  val (fieldNames: List[String], fieldValues: List[List[String]]) = 
    DB.runQuery("select games.name, count(tourn_gameindex.tourn_id) " +
        "from games left join tourn_gameindex on games.id = tourn_gameindex.gameid group by games.name")

  def render = {
    "tbody tr *" #> fieldValues.map { values => "td *" #> values }
  }
}