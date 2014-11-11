package code.snippet

import net.liftweb.util.Helpers._
import net.liftweb.mapper._

class Games {

  /*val (fieldNames: List[String], fieldValues: List[List[String]]) = 
    DB.runQuery("select games.id, games.name, count(tourn_gameindex.tourn_id) as numOfTournament " +
        "from games left join tourn_gameindex on games.id = tourn_gameindex.gameid group by games.id, games.name")*/

  // "tbody tr *" #> fieldValues.map { values => "td *" #> values }

  /*def render = {
    "tbody tr *" #> fieldValues.map( values => {
      "a [href]" #> appendParams("tournaments", Seq("id" -> values(0))) &
      "a *" #> values(1) &
      "@numOfTournament *" #> values(2) }
    )
  }*/

  val listOfGames = Db.listGame
  
  def render = {
    "tbody tr *" #> 
      listOfGames.map(values => { 
        "a *" #> values.get("name")  &
        "a [href]" #> appendParams("tournaments", Seq("id" -> values.get("id").toString)) & // values.get("id") &
        "@numOfTournament *" #> values.get("numOfTournament")
      })
  }
}