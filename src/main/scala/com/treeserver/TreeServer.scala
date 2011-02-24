package com.treeserver

import org.scalatra._
import java.io.PrintWriter


class TreeServer extends ScalatraServlet {
  get("*") {
    response.setContentType("text/javascript")
    val out = response.getWriter
    out.write("alert(\"Got personid and session: " + params("personid") + " " + params("sessionid") +  "\");")
  }
}