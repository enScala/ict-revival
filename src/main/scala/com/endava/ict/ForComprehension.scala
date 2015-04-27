package com.endava.ict

case class Book(title: String, authors: List[String])

object Library {
  val books: List[Book] = List(
    Book("Structure and Interpretation of Computer Programs",
      List("Abelson, Harold", "Sussman, Gerald J.")),
    Book("Principles of Compiler Design",
      List("Aho, Alfred", "Ullman, Jeffrey")),
    Book("Programming in Modula2",
      List("Wirth, Niklaus")),
    Book("Introduction to Functional Programming",
      List("Bird, Richard")),
    Book("The Java Language Specification",
      List("Gosling, James", "Joy, Bill", "Steele, Guy", "Bracha, Gilad")))

  def booksByAuthor(author: String) = {
    
  }

}