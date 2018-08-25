package combineByKey

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by weicheng on 2018/8/6.
  */
object RddMeCombineByKey {
  def main(args: Array[String]): Unit = {
    var sparkConf = new SparkConf().setAppName("combineByKey").setMaster("local")
    var sc = new SparkContext(sparkConf)
    val scores = sc.parallelize(List(("chinese", 88.0) , ("chinese", 90.1) , ("math", 60.2), ("math", 87.3)))
   /* scores.combineByKey(
      (v) => (v,1),
      (acc: (Float), v) => acc+ v,
      (acc1:(Float, Int), acc2:(Float, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2)
    )*/
    println(scores.getNumPartitions)
    val avg = scores.combineByKey(
      (v) => (v, 1),
      (acc: (Double, Int), v) => (acc._1 + v, acc._2 + 1),
      (acc1:(Double, Int), acc2:(Double, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2)
    ).map{ case (key, value) => (key, value._1 / value._2.toFloat) }

    println(avg.collect().mkString(","))

   /* scores.combineByKey(
      (v) => (v),
      (a :Double,v) => (a + v),
      (a : Double,b:Double) => (a + b)
    )*/

  }
}