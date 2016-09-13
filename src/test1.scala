// Use App base

object test1 extends App {
  def totalResultOverRange(number: Int, codeBlock: Int => Int) : Int = {
    var result : Int = 0
    for (i <- 1 to number) {
      result += codeBlock(i)
    }
    result
  }
  println("Hello World")
  
  println("even " + totalResultOverRange(11, i => if (i%2 ==0) 1 else 0))
  
  println("odd  " + totalResultOverRange(11, i => if (i%2 !=0) 1 else 0))

  def loopThrough(number: Int)(closure: Int=>Unit) {
    for (i <- 1 to number) { closure(i) }
  }
  
  var result = 0
  val addIt = { value: Int => result += value }
  
  loopThrough(10) { addIt }
  println("Total of values from 1 to 10 is " + result)
  
  result = 1
  loopThrough(5) { addIt }
  println("Total of values from 1 to  5 is " + result)
  
  var product = 1
  loopThrough(5) { product *= _ }
  println("Product of values from 1 to 5 is " + product)
}