import scala.collection.mutable.HashTable

/**
  * Created by User on 2016/09/27.
  */

object Element {

  private class ArrayElement(val contents: Array[String]) extends Element {
    override def demo() = {
      println("ArrayElement's Implementation invoked")
    }
  }


  private class LineElement(s: String) extends ArrayElement(Array(s)) {
    override def width = s.length

    override def height = 1

    override def demo() = {
      println("LineElement's Implementation invoked")
    }
  }

  private class UniformElement(
                                ch: Char,
                                override val width: Int,
                                override val height: Int
                              ) extends Element {
    private val line = ch.toString * width

    def contents = Array.fill(height)(line)

  }

  def elm(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elm(char: Char, width: Int, height: Int): Element =
    new UniformElement(char, width, height)

  def elm(line: String): Element =
    new LineElement(line)
}

import Element.elm

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  def demo(): Unit = {
    println("Element's Implementation invoked")
  }

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elm(this1.contents ++ that1.contents)
  }

  def beside(that: Element): Element = {
    val this1 = this height that.height
    val that1 = that height this.height
    elm(
      for (
        (line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )
  }

  def widen(w: Int) : Element = {
    if (w<=width) this
    else {
      val left  = elm(' ', (w-width)/2, height)
      val right = elm(' ', w-width-left.width, height)
      left beside this beside right
    }
  }

  def height(h: Int) : Element = {
    if(h<=height) this
    else {
      val top=elm(' ', width, (h-height)/2)
      val bot=elm(' ', width, h-height-top.height)
      top above this above bot
    }
  }
  override def toString = {
    contents.mkString("\n")
  }
}

object Spiral {
  val space = elm(" ")
  val corner = elm("+")

  def spiral(nEdges: Int, direction: Int): Element = {
    if (nEdges==1)
      elm("+")
    else {
      val sp = spiral(nEdges-1, (direction+3)%4)
      def vertialBar = elm('|', 1, sp.height)
      def horizontalBar = elm('-', sp.width, 1)
      if (direction==0) {
        (corner beside horizontalBar) above (sp beside space)
      } else if(direction==1) {
        (sp above space) beside (corner above vertialBar)
      } else if (direction==2) {
        (space beside sp) above (horizontalBar beside corner)
      } else {
        (vertialBar above corner) beside (space above sp)
      }
    }
  }
}

/*
val e1: Element = new ArrayElement(Array("hello", "world"))
val ae: ArrayElement = new LineElement("hello")
val e2: Element = ae
val e3: Element = new UniformElement('x', 2, 3)
*/

object run_element extends App {
  def invoke(e: Element) = {
    e.demo()
  }

  invoke(elm(Array("hello", "world")))
  invoke(elm("hello world"))
  invoke(elm('Z', 3, 2))

  println(Spiral.spiral(20, 0))
}