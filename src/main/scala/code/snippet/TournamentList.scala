package code.snippet

import net.liftweb.http._
import net.liftweb.util.Helpers._
import net.liftweb.mapper._

class TournamentList {

  /*val (fieldNames: List[String], fieldValues: List[List[String]]) = 
    DB.runQuery("select games.name, count(tourn_gameindex.tourn_id) " +
        "from games left join tourn_gameindex on games.id = tourn_gameindex.gameid group by games.name")*/

  // "tbody tr *" #> fieldValues.map { values => "td *" #> values }

  val listOfGames = Db.listGame
  val id = S.param("id") openOr ""

  def render = {
    "a [href]" #> appendParams("newTournament", Seq("id" -> id))  // values.get("id") &
    // "tbody tr *" #> 
    //   listOfGames.map(values => { 
    //     "a *" #> values.get("name")  &
    //     "a [href]" #> appendParams("gameList", Seq("id" -> values.get("id").toString)) & // values.get("id") &
    //     "@numOfTournament *" #> values.get("numOfTournament")
    //   })
  }
}