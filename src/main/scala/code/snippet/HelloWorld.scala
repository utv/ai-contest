package code 
package snippet 

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import java.sql._
import scala.slick.session.Database
import sqltyped._
import net.liftweb.mapper._

class HelloWorld {
  
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date
  val url = appendParams("main",
                      ("first_param" -> "358") ::
                      ("second_param" -> "Something with spaces") :: Nil)

  val list = Db.listGame(1) get "name"
  val showList = Db.listGame

  def howdy = "#time *" #> date.map(_.toString)
  def links = "a *" #> "This is the link text"& "a [href]" #> url
  def render = "* *" #> "render hello"

}
