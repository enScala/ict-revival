package com.endava.ict

class HigherOrder {

  def incrementResult(prefix: String, v: Int, f: Int => Int): Int =
    f(v) + 1

  def combine[A](z: A, c: (A, A) => A, v: A, f: A => A): A =
    c(z, f(v))

  val doubleAbs = (x: Int) => 2 * Math.abs(x)

  def partial[A, B, C] (a: A, f: (A, B) => C): B => C =
    (b: B) => f(a, b)

  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    (a: A) => ((b: B) => f(a, b))

  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))

}
