package com.endava.ict

sealed trait JSON

case object JNull extends JSON

case class JNumber(num: Double) extends JSON
case class JString(str: String) extends JSON
case class JBoolean(b: Boolean) extends JSON
case class JArray(elems: List[JSON]) extends JSON
case class JObject(bindings: Map[String, JSON]) extends JSON
