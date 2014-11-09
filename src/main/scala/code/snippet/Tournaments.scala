package code.snippet

import net.liftweb.http._
import net.liftweb.util.Helpers._
import net.liftweb.mapper._

class TournamentList {
  val listOfTournaments = Db.listTournament(S.param("id").get.toInt)
  val id = S.param("id") openOr ""

  def render = {
    "a [href]" #> appendParams("newTournament", Seq("id" -> id)) &
    "tbody tr *" #> 
      listOfTournaments.map(values => { 
        "a *" #> values.get("tournament_name")  &
        "a [href]" #> appendParams("tournamentDetail", Seq("id" -> values.get("id").toString)) & // values.get("id") &
        "@creator *" #> values.get("creator")
      })
  }
}