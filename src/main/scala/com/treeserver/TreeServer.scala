package com.treeserver

import org.scalatra._


class TreeServer extends ScalatraServlet {
  get("/person/:id") {
    <p>Hello,
      {params("id")} with session {params("sessionid")}
    </p>
  }

}