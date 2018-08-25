package scalaclass

/**
  * Created by weicheng on 2018/8/21.
  */
class Point(xc: Int, yc: Int) extends Equal{
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println ("x 的坐标点: " + x);
    println ("y 的坐标点: " + y);
  }

  def isEqual(obj: Any) =
    obj.isInstanceOf[Point] &&
      obj.asInstanceOf[Point].x == x

   override def toString = getClass.getName + "[name=" + x + "]"
}
