package com.endava.ict

import scala.annotation.tailrec

object Recursion {

  /**
   * Traditional implementation of a function that uses recursion
   * its execution flow looks as follows:
   *
   * factorial(5)
   * if(5 <= 0) 1 else 5 * factorial(5 - 1)
   * 5 * factorial(4)
   * 5 * (4 * factorial(3))
   * 5 * (4 * (3 * factorial(2)))
   * 5 * (4 * (3 * (2 * factorial(1))))
   * 5 * (4 * (3 * (2 * 1)))
   * 120
   */
  def factorial(a: Int): Int = {
    if (a <= 0)
      1
    else
      a * factorial(a - 1)
  }
}

object TailRecursion {

  /**
   * Function that calculates the factorial of a number. It calls *factorialImpl* that actually performs the calculation
   */
  def factorial(a: Int) = {

    /**
     * Function that makes use of tail-recursion
     * the @tailrec annotation allows the scala compiler to verify if this is actually a tail-recursive function
     * its not necessary (see TailRecursion2), but it's useful to keep your "peace-of-mind" :)
     *
     * its execution flow is as follows:
     * 
     * factorialImpl(3, 1)
     *  if (3 <= 0) 1 else factorialImpl(3 - 1, 3 * 1)
     * if (false) 1 else factorialImpl(2, 3)
     * factorialImpl(2, 3)

     * if (2 <= 0) 3 else factorialImpl(2 - 1, 3 * 2)
     * if (false) 3 else factorialImpl(1, 6)
     * factorialImpl(1, 6)

     * if (1 <= 0) 6 else factorialImpl(0, 6 * 1)
     * if (false) 6 else factorialImpl(0, 6)
     * factorialImpl(0, 6)

     * if (0 <= 0) 6 else factorialImpl(0 - 1, 6)
     * if (true) 6 else factorialImpl(0 - 1, 6)
     * 6
     *
     */
    @tailrec
    def factorialImpl(a: Int, result: Int) : Int = {
      if (a <= 0)
        result
      else
        factorialImpl(a - 1, a * result)
    }

    /**
     * apply the tail-recursive function
     */
    factorialImpl(a, 1)
  }
}

object TailRecursion2 {

  /**
   * Function that calculates the Greatest Common Divisor using tail-recursion
   * its execution flow is as follows:
   *
   * gcd(14, 21)
   *  if (21 == 0) 14 else gcd(21, 14 % 21)
   *  if (false) 14 else gcd(21, 14 % 21)
   *  gcd(21, 14 % 21)
   *  gcd(21, 14)
   *
   *  if (14 == 0) 21 else gcd(14, 21 % 14)
   *  gcd(14, 21 % 14)
   *  gcd(14, 7)
   *
   *  if (7 == 0) 14 else gcd(7, 14 % 7)
   *  gcd(7, 14 % 7)
   *  gcd(7, 0)
   *
   * if (0 == 0) 7 else gcd(0, 7 % 0)
   *  7
   */
  def gcd(a: Int, b: Int): Int = {
    if (b == 0)
      a
    else
      gcd(b, a % b)
  }
}
