
/**
  * Created by User on 2016/09/09.
  */
import scala.actors.Actor._


object my_actor extends App {
  println("Hello")

  var startTime : Long = 0
  val caller = self

  val engrossActor = actor {
    println("Num of message received so far? " + mailboxSize)
    caller ! "send"
    Thread.sleep(4000)
    println("Num of message received while I was busy? ", mailboxSize)
    receive {
      case msg =>
        val receivedTime = System.currentTimeMillis() - startTime
        println("Received message " + msg + " after " + receivedTime + " ms")
    }
    caller ! "received"
  }

  receive { case _ => }

  println("Sending Message ")
  startTime = System.currentTimeMillis()
  engrossActor ! "Hello Buddy"
  val endTime = System.currentTimeMillis() - startTime

  printf("Took less than %dms to send message\n", endTime)

  receive {
    case _ =>
  }
}