/**
  * Created by zheng on 2016/9/25.
  */

class Rational(n: Int, d: Int) {

  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1) // constructor

  override def toString: String = numer + "/" + denom

  def +(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)
  }

  def +(i: Int) : Rational = {
    this + new Rational(i)
  }

  def -(that: Rational): Rational = {
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom)
  }

  def -(i: Int) : Rational = {
    this - new Rational(i)
  }

  def *(that: Rational): Rational = {
    new Rational(
      numer * that.numer, denom * that.denom
    )
  }

  def *(i: Int) : Rational = {
    this * new Rational(i)
  }

  def <(that: Rational) = {
    this.numer * that.denom < that.numer * this.denom
  }

  def max(that: Rational) = {
    if (this < that) that else this
  }

  private def gcd(a: Int, b: Int) : Int= {
    if (b==0) a else gcd(b, a%b)
  }
}

object new_app extends App {
  //def main(args: Array[String]): Unit = {
  println("compile ok!")

  val a = new Rational(1, 2)
  val b = new Rational(2, 3)
  val c = a + b
  val d = a * b

  print(a)
  print(" + ")
  print(b)
  print(" = ")
  println(c)

  print(a)
  print(" * ")
  print(b)
  print(" = ")
  println(d)

  println(a+2)
  implicit def intToRational(x: Int) = new Rational(x)
  println(2+a)
  val e = new Rational(66, 42)
  println(e)
  println(e.numer, e.denom)
  //}
}