package com.endava.ict

object QuicksortImperative {

  def sort(array: Array[Int]): Array[Int] = {

    def swap(i: Int, j: Int) {
      val t = array(i); array(i) = array(j); array(j) = t
    }

    def sort1(l: Int, r: Int) {
      val pivot = array((l + r) / 2)
      var i = l; var j = r
      while (i <= j) {
        while (array(i) < pivot) i += 1
        while (array(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) sort1(l, j)
      if (j < r) sort1(i, r)
    }

    sort1(0, array.length - 1)
    array
  }

}
