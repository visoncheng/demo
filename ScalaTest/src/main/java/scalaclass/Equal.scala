package scalaclass

/**
  * Created by weicheng on 2018/8/22.
  */
trait Equal {
  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}
