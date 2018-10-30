package com.github.scalatrareactboilerplate

import org.scalatra._

class AppRouter extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

}
