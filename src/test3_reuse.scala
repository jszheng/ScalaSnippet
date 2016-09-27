import java.io.File

/**
  * Created by zheng on 2016/9/25.
  */

object FileMatcher {
  private def filesHere = (new File("*.*")).listFiles()

  private def filesMatching(matcher: String => Boolean) = {
    for (file <- filesHere if matcher(file.getName))
      yield file
  }

  def filesEnding(query: String) = filesMatching(_.endsWith(query))
  def filesContaining(query: String) = filesMatching(_.contains(query))
  def filesRegex(query: String) = filesMatching(_.matches(query))
}
object test3_reuse extends App {

}
