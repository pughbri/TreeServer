package com.treeserver

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec


@RunWith(classOf[JUnitRunner])
class TestTreeServer extends FlatSpec with ShouldMatchers {
  "TreeServer" should "get person XML" in {
     val person = TreeServer.getPerson("USYSC102A89C15C407D27BB7B76CB066DFE0_naci-045-033.d.usys.fsglobal.net","KWQ3-LV1")
     person.name should be === "Warren Edward PUGH"
     person.father.name should be === "William Edward PUGH"
     person.mother.name should be === "Eva May MURPHY"
  }

}