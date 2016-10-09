/**
  * Created by zheng on 2016/9/29.
  */

object cal_sqrt extends App {
  def abs(x: Double) = if (x < 0) -x else x


  def sqrt(x: Double) = {

    def isGoodEnough(guess: Double): Boolean = {
      abs(guess * guess - x) /x < 0.0001
    }

    def improve(guess: Double): Double = {
      (guess + x / guess) / 2
    }

    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else {
        //println(guess)
        sqrtIter(improve(guess))
      }
    }
    sqrtIter(1.0)
  }

  println(sqrt(2))
  println(sqrt(1e-10))
  println(sqrt(1e60))
}