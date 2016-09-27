// trait
// auto convert for DSL
import DateHelper._

object test2 extends App {
  val past = 2 days ago
  val appointment = 5 days from_now
  
  println(past)
  println(appointment)

  def makeRowSeq(row: Int) = {
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }
  }

  def makeRow(row: Int) = makeRowSeq(row).mkString

  def multiTable() = {
    val tableSeq = {
      for (row <- 1 to 10)
        yield makeRow(row)
    }
    tableSeq.mkString("\n")
  }
  println(multiTable)

  // closure
  var more = 1
  val addMore = (x: Int) => x + more

  println(addMore(10))

  more = 9999
  println(addMore(10))

  val changeMore = (x: Int) => more += x
  changeMore(1)
  println(more)
}