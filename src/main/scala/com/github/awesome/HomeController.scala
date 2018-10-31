package com.playground.awesome

import org.json4s.{DefaultFormats, Formats}
import org.scalatra._
import scala.collection.mutable.ListBuffer
import scalate.ScalateSupport
import org.scalatra.json._
import org.scalatra.util.conversion.TypeConverter

class HomeController extends ScalatraServlet with ScalateSupport {

  get("/") {
    contentType = "text/html"
    ssp("/home")
  }

}
