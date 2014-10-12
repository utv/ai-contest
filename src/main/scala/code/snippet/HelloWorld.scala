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

class HelloWorld {
  
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date
  val url = appendParams("main",
                      ("first_param" -> "358") ::
                      ("second_param" -> "Something with spaces") :: Nil)

  val list = Db.listGame(1) get "name"
  // def howdy = "#time *" #> date.map(_.toString) & "#answer *+" #> Db.myFirstname(0)
  def howdy = "#time *" #> date.map(_.toString) & "#answer *+" #> list
  def links = "a *" #> "This is the link text"& "a [href]" #> url
  def render = "* *" #> "render hello"

  def listGame = {
  	
  }
}
