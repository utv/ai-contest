package code.snippet

import _root_.net.liftweb._
import http._
import SHtml._
import js._
import JsCmds._
import js.jquery._
import JqJsCmds._
import common._
import util._
import Helpers._
import _root_.scala.xml.NodeSeq
class JSDialog {
	// build the button... when pressed, present
	// a dialog based on running the _jsdialog_confirm
	// template
	def button(in: NodeSeq) =
		ajaxButton(in, () => {
			S.runTemplate(List("modal"))
			}.map(ns => ModalDialog(ns)) openOr Alert("Couldn't find _jsdialog_confirm template"))
	// the template needs to bind to either server-side behavior
	// and unblock the UI
	def confirm =
		"#yes" #> ((b: NodeSeq) => ajaxButton(b, () => {
			Unblock & Alert("Rhode Island Destroyed")
			})) &
				"#no" #> ((b: NodeSeq) => <button onclick={Unblock.toJsCmd}>
					{b}
					</button>)
}