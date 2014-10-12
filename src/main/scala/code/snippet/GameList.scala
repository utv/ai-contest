package code.snippet

import net.liftweb.util.Helpers._

class GameList {

  val list = Db.listGame

  def render = {
    "tbody tr td *" #> "xxx"
  }
}