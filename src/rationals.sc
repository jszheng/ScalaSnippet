object rationals {
  val x = new Rational(2, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.numer
  x.denom

  x + y + z
  y + y
  val r2 = new Rational(4)

  new Rational(1, 2).less(new Rational(2, 3))
  x > y
  x max y
  x - y

}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def numer = x

  def denom = y

  def +(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  override def toString: String = {
    val g = gcd(numer, denom)
    if (denom / g == 1) numer.toString else numer / g + "/" + denom / g
  }

  def less(that: Rational) = {
    this.numer * that.denom < that.numer * this.denom
  }

  def *(that: Rational): Rational = {
    new Rational(
      numer * that.numer, denom * that.denom
    )
  }

  def *(i: Int): Rational = {
    this * new Rational(i)
  }

  def unary_- : Rational = new Rational(-numer, denom)

  def <(that: Rational) = less(that)

  def >(that: Rational) = !less(that)

  def max(that: Rational) = if (this < that) that else this

  def -(that: Rational) = this + -that
}
