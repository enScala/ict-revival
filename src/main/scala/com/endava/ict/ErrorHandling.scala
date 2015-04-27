package com.endava.ict

class ErrorHandling {

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
  
  case object Option {

    def average(list: List[Double]): Double =
      list.sum / list.length

    def average2(list: List[Double]): Option[Double] =
      if (list.isEmpty) None
      else Some(list.sum / list.length)
    
  }

  sealed abstract class Try[+T]
  final case class Failure[+T](exception: Throwable) extends Try[T]
  final case class Success[+T](value: T) extends Try[T]

  sealed trait Either[+E,+A]
  case class Left[+E](get: E) extends Either[E, Nothing]
  case class Right[+A](get: A) extends Either[Nothing, A]

}
