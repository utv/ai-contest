package code.snippet

import net.liftweb.http._
import net.liftweb.util.Helpers._
import net.liftweb.mapper._

class Tournaments {
  val id = S.param("game_id") openOr ""
  val listOfTournaments = Db.listTournament(id.toInt)

  def render = {
    "a [href]" #> appendParams("newTournament", Seq("game_id" -> id)) &
    "tbody tr *" #> 
      listOfTournaments.map(values => { 
        "a *" #> values.get("tournament_name")  &
        "a [href]" #> appendParams("tournament", Seq("tourn_id" -> values.get("tourn_id").toString)) &
        "@creator *" #> values.get("creator")
      })
  }
}