package com.playground.awesome

import org.json4s.{DefaultFormats, Formats}
import org.scalatra._
import scala.collection.mutable.ListBuffer
import scalate.ScalateSupport
import org.scalatra.json._
import org.scalatra.util.conversion.TypeConverter

class PlanetsApiController extends ScalatraServlet with JacksonJsonSupport {

  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  // all results from controller are json
  before() {
    contentType = formats("json")
  }

  object AppStateCache {
    val planets = ListBuffer[Planet](
      new Planet("Mercury", "1", "hot and iron")
    )
  }

  case class Planet(
    name: String,
    orbit: String,
    features: String
  )

  def toPlanet(str: String) = str.split(',').
    map(_.trim) match {
      case Array(name, orbit, features) =>
        Planet(name, orbit, features)
  }

  implicit val stringToPlanet:
    TypeConverter[String, Planet] =
      safe { 
        str => toPlanet(str)
      }

  get("/planets") {
    AppStateCache.planets
  }

  post("/planets/submit") {
    val name = params.getAs[String]("name").getOrElse(
      halt(BadRequest("Please provide a name"))
    )
    val orbit = params.getAs[String]("orbit").getOrElse(
      halt(BadRequest("Please provide an orbit"))
    )
    val features = params.getAs[String]("features").getOrElse(
      halt(BadRequest("Please provide planetery feastures"))
    )
    AppStateCache.planets += new Planet(name, orbit, features)
  }

  get("/planets/:debug") {
    val debug = params("debug")
  }

}
