package com.endava.ict

object ADT {

  sealed trait JSON

  case object JNull extends JSON

  case class JNumber(num: Double) extends JSON
  case class JString(str: String) extends JSON
  case class JBoolean(b: Boolean) extends JSON
  case class JArray(elems: List[JSON]) extends JSON
  case class JObject(bindings: Map[String, JSON]) extends JSON

  case object instance {
    def toJson(): JSON = ???
  }

  val json = instance.toJson()

  json match {
    case JNumber(num) =>
      "it's a number"
    case JString(str) =>
      "it's a string"
    case _ =>
      "it's something else"
  }


  sealed trait List[+A]

  case object Nil extends List[Nothing]
  case class Cons[+A](head: List[A], tail: List[A]) extends List[A]

}
