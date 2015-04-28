package com.endava.ict

object FunctionsAsValues {

  val one : Int = 1
  val two : Int = 2

  /**
   * Function takes two Ints as arguments and returns their sum as a String value
   *
   * The function itself is no different than any other value (i.e. it can be passed as an argument to another function)
   */
  val func : (Int, Int) => String = (a: Int, b: Int) =>
  {
    (a + b).toString
  }

  /**
   * Function that takes another function as an argument
   */
  def sumOfTwoIntegers(f: (Int, Int) => String) : String =
  {
    /**
     * apply the function value passed as the argument
     */
    f(1, 2)
  }
}

object Closure {

  var one = 2

  /**
   * Function is considered *open* since it needs the variable *one*, which is defined outside its scope
   * At runtime it captures (also called it *closes* over) *one*, hence the name *closure*
   */
  def func(a : Int) : Int = {
    a + one
  }
}

object PureVsImpureFunctions {

  class Person(var address: String) {
    def change(newAddress: String) =
      address = newAddress
  }

  // has side-effects because it changes the person object
  def impure (person: Person, newAddress: String) : Unit = {
    person.change(newAddress)
  }

  // no side-effects because the result depends only on its parameters
  def pure(a: Int, b: Int) : Int = a + (b * 2)

}




