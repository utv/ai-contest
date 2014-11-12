package code.snippet

import net.liftweb.http._
import net.liftweb.util.Helpers._
import net.liftweb.mapper._

class Tournament {
  val tourn_id = S.param("tourn_id") openOr ""
  val leaderBoard = Db.leaderBoard(tourn_id.toInt)

  def render = {
    "#new_bot [href]" #> appendParams("newBot", Seq("tourn_id" -> tourn_id)) &
    "#choose_bot [href]" #> appendParams("chooseBot", Seq("tourn_id" -> tourn_id)) &
    "tbody tr *" #> 
      leaderBoard.map(values => { 
        "@rank *" #> values.get("rank")  &
        "@bot_name *" #> values.get("bot_name") 
      })
  }
}