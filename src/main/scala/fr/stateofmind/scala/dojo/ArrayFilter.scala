package fr.stateofmind.scala.dojo

/*
 * Task: http://projecteuler.net/problem=1
 * Description: Find the sum of all the multiples of 3 or 5 below 1000.
 */
class ArrayFilter(n: Int) {

  def sum: Int = this.filterArray.sum

  def preparedArray: Array[Int] = Array.range(1, n)

  private def filterArray: Array[Int] = {
    this.preparedArray.filter((x: Int) => (x % 3 == 0 || x % 5 == 0))
  }

}
