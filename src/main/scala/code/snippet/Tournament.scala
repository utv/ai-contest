package code.snippet

import net.liftweb.http._
import net.liftweb.util.Helpers._
import net.liftweb.mapper._

class Tournament {
  val id = S.param("tourn_id") openOr ""
  // val leaderBoard = Db.leaderBoard(id.toInt)

  def render = {
    "a [href]" #> appendParams("newBot", Seq("tourn_id" -> id))
    /*"tbody tr *" #> 
      listOfTournaments.map(values => { 
        "a *" #> values.get("tournament_name")  &
        "a [href]" #> appendParams("tournament", Seq("tourn_id" -> values.get("tourn_id").toString)) &
        "@creator *" #> values.get("creator")
      })*/
  }
}