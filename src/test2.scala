// trait
// auto convert for DSL
import DateHelper._

object test2 extends App {
  val past = 2 days ago
  val appointment = 5 days from_now
  
  println(past)
  println(appointment)
}