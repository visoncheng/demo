import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by weicheng on 2018/8/3.
  */
object RddPair {
  def main(args: Array[String]): Unit = {
    var sparkConf = new SparkConf().setAppName("RddPair").setMaster("local")
    var sc = new SparkContext(sparkConf)

//    var list = sc.parallelize(List(5,7,4))
//    var pair = list.map(x => (x,x)).persist()
    var pair = sc.parallelize(List((1,2),(2,3),(3,4)))
//    println(pair.collect().mkString(","))
//    println(pair.reduceByKey((x,y) => x + y).collect().mkString(",")) //相同的key对应的value值相加
//    println(pair.groupByKey().collect().mkString(",")) //相同key分组，value放在一起
//    println(pair.mapValues(x => x + 1).collect().mkString(",")) //对value进行操作
//    println(pair.flatMapValues(x => (x to 6)).collect().mkString(","))
//    println(pair.keys.collect().mkString(","))
    var other = sc.parallelize(List((2,5),(2.7)))
//    println(pair.join(other).collect().mkString(","))
    println(pair.filter{case (x,y) =>x + y!= 5}.collect().mkString(","))

  /*  val rddPair = sc.parallelize(List(("x01", 2), ("x02", 5), ("x03", 8), ("x04", 3), ("x01", 12), ("x03", 9)))
    val rddFlatMap1= rddPair.flatMap(x => List((x._1 + "@a",x._2 + 3000)))
    println("=====flatMap 1======:" + rddFlatMap1.collect().mkString(","))*/
  }
}
