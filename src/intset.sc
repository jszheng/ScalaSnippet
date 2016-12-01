object intsets {
  //new IntSet {}
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 9
  val t3 = t2 incl 7 incl 666
  val t4 = t3 incl 100

  val t5 = new Empty incl 1
  val t6 = t5 incl 19 incl 9

  val t7 = t6 union t4

  t7 contains 999
  println(t7 contains 9)
}

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet) : IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false

  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  def union(other: IntSet) : IntSet = other

  override def toString: String = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def union(other: IntSet) : IntSet =
    ((left union right) union other) incl elem

  override def toString: String = "{" + left + elem + right + "}"
}
