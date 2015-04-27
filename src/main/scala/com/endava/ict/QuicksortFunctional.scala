package com.endava.ict

object QuicksortFunctional {

  def sort(array: Array[Int]): Array[Int] = {
    if (array.length <= 1) array
    else {
      val pivot = array(array.length / 2)
      Array.concat(
        sort(array filter (x => pivot > x)),
             array filter (x => pivot == x),
        sort(array filter (x => pivot < x)))
    }
  }

  // for illustration
  def filter(p: Int => Boolean): Array[Int] = ???

}
