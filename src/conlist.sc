object conlist {
  def nth[T](n: Int, xs: List[T]): T = {
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    if (n==0) xs.head
    else nth(n-1, xs.tail)
  }

  val list = new Cons(1,  new Cons(2, new Cons(3, new Cons(4, new Nil))))

  nth(1, list)
  nth(3, list)
}

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty : Boolean = true
  def head : Nothing = throw new Error("No head")
  def tail : Nothing = throw new Error("No tail")
}

object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
}