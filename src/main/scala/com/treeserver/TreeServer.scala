package com.treeserver

import org.scalatra._
import java.io.PrintWriter
import org.apache.commons.httpclient.methods.GetMethod
import org.apache.commons.httpclient.params.HttpMethodParams
import org.apache.commons.httpclient.{DefaultHttpMethodRetryHandler, HttpClient}


case class Person(name: String, mother: Person, father: Person)

class TreeServer extends ScalatraServlet {
  get("*") {
    val person = TreeServer.getPerson(params("sessionid"), params("personid"))
    response.setContentType("text/javascript")
    val out = response.getWriter
    out.write("alert(\"Got personid and session: " + params("personid") + " " + params("sessionid") + "\");")
    out.write("alert(\"" + person.toString + "\");")
  }
}

object TreeServer {
  def getPerson(sessionId: String, personId: String): Person = {
    val treeXML = getPersonXml(sessionId, personId)

    val name = (treeXML \\ "name" \\ "fullText").text
    val parentsXML = treeXML \\ "parents" \\ "parent"
    var mom: Person = null
    var dad: Person = null
    for (parentXML <- parentsXML.elements) {
      val parentId = (parentXML \ "@id").text
      if (parentId != personId) {
        (parentXML \ "@gender").text match {
          case "Male" => dad = getPerson(sessionId, parentId)
          case "Female" => mom = getPerson(sessionId, parentId)
          case _ =>
        }
      }
    }

    Person(name, mom, dad)
  }

  def getPersonXml(sessionId: String, personId: String) = {
    val treeUrl = "http://www.dev.usys.org/familytree/v2/person/" + personId + "?parents=all&sessionId=" + sessionId
    val client = new HttpClient()
    val method = new GetMethod(treeUrl)
    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
      new DefaultHttpMethodRetryHandler(3, false))
    val statusCode = client.executeMethod(method)
    val responseBody = new String(method.getResponseBody())

    scala.xml.XML.loadString(responseBody)
  }
}