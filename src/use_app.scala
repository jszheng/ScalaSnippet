// more simple ways
import scala.collection.mutable.Map

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) {sum += b} // return is Unit
  def g() = {"This string get returned"}
  def checksum(): Int = ~(sum & 0xFF) + 1
}

object use_app extends App {
  def formatArgs(args: Array[String]) = args.mkString("\n")

  println("Hello, world!")
  //args.foreach(println)
  println(formatArgs(args))

  val oneTwo = List(1,2)
  val threeFour = List(3,4)
  val all = oneTwo ::: threeFour
  println(all)

  val treasureMap = Map[Int, String] ()
  treasureMap += (1 -> "goto island")
  treasureMap += (2 -> "Find big X on ground")
  treasureMap += (3 -> "Dig")
  println(treasureMap)
}