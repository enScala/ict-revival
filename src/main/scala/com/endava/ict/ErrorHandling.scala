package com.endava.ict

object ErrorHandling {

  def fail1(i: Int): Int = {
    val y: Int = throw new Exception()
    try {
      val x = 1
      x + y
    }
    catch {
      case e: Exception => 10
    }
  }

  def fail2(i: Int): Int = {
    try {
      val x = 1
      x + (throw new Exception()): Int
    }
    catch {
      case e: Exception => 10
    }
  }
  
  sealed trait Option[+A] {}
  case class Some[+A](get: A) extends Option[A]
  case object None extends Option[Nothing]

  def average(list: List[Double]): Double =
    list.sum / list.length

  def average2(list: List[Double]): Option[Double] =
    if (list.isEmpty) None
    else Some(list.sum / list.length)

  sealed abstract class Try[+T]
  final case class Failure[+T](e: Throwable) extends Try[T]
  final case class Success[+T](value: T) extends Try[T]

  def divide(a: Int, b: Int): Try[Int] =
    try {
      Success(a / b)
    } catch { case ex: Exception => Failure(ex) }

  def safe(a: Int, b: Int): String = {
    val result = divide(a, b)
    //use pattern matching to handle both cases
    result match {
      case Success(result) => "yay!"
      case Failure(exception) => "oh, no!"
    }
  }

  sealed trait Either[+E,+A]
  case class Left[+E](get: E) extends Either[E, Nothing]
  case class Right[+A](get: A) extends Either[Nothing, A]

  case object Either {

    def eitherOperation(a: Int): Either[String, Int] = {
      if (a > 0) Right(a)
      else Left("integer is negative")
    }

    def getPositiveNum(a: Int) = {
      //use pattern matching to handle both cases
      eitherOperation(a) match {
        case Right(right) => // we have a positive number,
        case Left(left) => // we have a string
      }
    }
  }
}
