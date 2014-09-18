package code 
package snippet 

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import java.sql._
import sqltyped._

class HelloWorld {
  
    
  Class.forName("org.postgresql.Driver")
  implicit def conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ai", "ai", "ai")


  
//  val p = sql("select name from users where id > ? and name=?").apply(2, "James")
//  val q = sql("select name from users where id > ?").apply(1)
  val row = sql("select tel from person where lastname=?").apply(Some("dee"))
  val rows = sql("select firstname from person").apply()
  
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  val url = appendParams("main",
                      ("first_param" -> "358") ::
                      ("second_param" -> "Something with spaces") :: Nil)

  // val url = "main"

  // replace the contents of the element with id "time" with the date
  def howdy = {
    //"#time *" #> date.map(_.toString) & "#chat *" #> q.toString
	"#time *" #> date.map(_.toString) //& "#chat *" #> q.toString
  }
  
  def links = {
    
    "a *" #> "This is the link text"& "a [href]" #> url
  }
    
  
  def test = "#answer *" #> rows(0)
  
  
  def render = "* *" #> "render hello"

  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */
}

