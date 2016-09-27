import java.io.File
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

/**
  * Created by zheng on 2016/9/25.
  */

object fileop extends App {
  val filesHere = (new File("./src/")).listFiles
  for (file <- filesHere if file.getName.endsWith(".scala")) {
    println(file)
  }

  try {
    val f = new FileReader("README.md")
    println("file opened")
    try {
      // use the file
      println("useing file")
    } finally {
      f.close()
    }
  } catch {
    case ex: FileNotFoundException => print("File Not found")
    case ex: IOException => print("Unknown Error")
  }


}
