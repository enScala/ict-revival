package com.endava.ict

case class Book(title: String, authors: List[String])

object Library {

  /**
   * An example library database containing books and their authors
   */
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

  /**
   * Find all books written by a certain author
   */

  def titlesByAuthor2(author: String) : List[String] =
    for {
      b <- books
      a <- b.authors
      if a.toLowerCase startsWith author.toLowerCase
    } yield b.title

  /**
   * Find all authors that have written two books
   */
  def popularAuthors() : List[String] = {
    val authors = for (b1 <- books; b2 <- books; if b1 != b2;
         a1 <- b1.authors; a2 <- b2.authors if a1 == a2)
    yield a1
    removeDuplicates(authors)
  }

  /**
   * A helper function. Selects only distinct values from a list
   */
  def removeDuplicates[A](xs: List[A]): List[A] =
    if (xs.isEmpty)
      xs
    else
      xs.head :: removeDuplicates(xs.tail filter (x => x != xs.head))
}