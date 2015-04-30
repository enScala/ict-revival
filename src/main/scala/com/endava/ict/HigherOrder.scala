package com.endava.ict

class HigherOrder {

  def incrementResult(v: Int, f: Int => Int): Int =
    f(v) + 1

  def combine[A](z: A, c: (A, A) => A, v: A, f: A => A): A =
    c(z, f(v))

  val doubleAbs = (x: Int) => 2 * Math.abs(x)

  object ForRealMen {

    def partial[A, B, C] (a: A, f: (A, B) => C): B => C =
      (b: B) => f(a, b)

    def curry[A,B,C](f: (A, B) => C): A => (B => C) =
      (a: A) => (b: B) => f(a, b)

    def uncurry[A,B,C](f: A => B => C): (A, B) => C =
      (a: A, b: B) => f(a)(b)

    def compose[A,B,C](f: B => C, g: A => B): A => C =
      (a: A) => f(g(a))

  }

  object ForEveryoneElse {

    def partial3[A, B, C] (a: A, f: (A, B) => C): B => C =
      (b: B) => f(a, b)

    def partial (a: Int): Int => Int =
      (b: Int) => a + b
    
    val plusOne: Int => Int = partial(1)
    
    plusOne(2) == partial(1)(2) // == 3

    def simpleFunction(a: Int, b: Int) = a + b

    val partial4 = simpleFunction(3, _)
    
    partial4(3)

    def partial2 (a: Int, f: (Int, Int) => Int): Int => Int =
      (b: Int) => f(a, b)

    def curry(f: (Int, Int) => Int): Int => (Int => Int) =
      (a: Int) => (b: Int) => f(a, b)

    def uncurry(f: Int => Int => Int): (Int, Int) => Int =
      (a: Int, b: Int) => f(a)(b)

    def compose(f: Int => Int, g: Int => Int): Int => Int =
      (a: Int) => f(g(a))

  }


}
