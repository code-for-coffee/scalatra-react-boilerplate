package com.playground.awesome

import org.scalatra.test.scalatest._

class AppRouterTests extends ScalatraFunSuite {

  addServlet(classOf[AppRouter], "/*")

  test("GET / on AppRouter should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
