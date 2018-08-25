/**
  * Created by weicheng on 2018/8/21.
  */
object Drunkard {
  //最开始拥有的软妹币
  var money = 10
  //每天喝掉一个软妹币
  def drink: Unit = {
    money -= 1
  }
  //数钱时要算上被喝掉的软妹币
  def count: Int = {
    drink
    money
  }

  //传名调用
  //每天都数钱
  def printByName(x: => Int): Unit = {
    for(i <- 0 until 5)
      println("每天算一算，酒鬼还剩" + x + "块钱！")
  }

  //传值调用
  //第一天数一下记墙上，以后每天看墙上的余额
  def printByValue(x: Int): Unit = {
    for(i <- 0 until 5)
      println("只算第一天，酒鬼还剩" + x + "块钱！")
  }

  def main(args: Array[String]) = {
    printByName(count)
    printByValue(count)
  }

}
