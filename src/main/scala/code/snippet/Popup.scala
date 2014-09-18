package code.snippet

import scala.collection.{ mutable, immutable, generic }
import scala.xml.{NodeSeq, Text}
import net.liftweb.http._
import net.liftweb.http.SHtml._
import net.liftweb.util._
import Helpers._
import net.liftweb.http.js.jquery.JqJsCmds.ModalDialog
import js._
import js.jquery._

import JsCmds._

class Popup {
  def displayModal = {
    /*"#clickable_span [onclick]" #> 
      SHtml.ajaxInvoke(() => ModalDialog(<div class={"lift:SinglePageForm"}></div>))*/
    "#clickable_span [onclick]" #> 
      SHtml.onEvent(s => ModalDialog(<div><div class={"lift:SinglePageForm?ajax=true"}/></div>))
    
  }
}