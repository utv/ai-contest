package code.snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import net.liftweb.http.S

class MainWorld {
  val param = S.param("first_param") openOr "No parameter 'name' given"
  def writeText = "#ddd *" #> param
}