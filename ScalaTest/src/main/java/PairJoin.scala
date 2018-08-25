import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

/**
  * Created by weicheng on 2018/8/6.
  */
object PairJoin {
  def main(args: Array[String]): Unit = {
    var sparkConf = new SparkConf().setAppName("join").setMaster("spark://master:7077")
    var sc = new SparkContext(sparkConf)

    //分区
    var left = sc.parallelize(List(("a","1"),("b","2"),("c","3"))).partitionBy(new HashPartitioner(10))
    var right = sc.parallelize(List(("a","11"),("b","22"),("d","44")))
    var third = sc.parallelize(List(("a","15")))

    println(right.toDebugString)
    //获取分区数
//    println(left.getNumPartitions)
//    println(right.getNumPartitions)
//    println(left.partitioner)
//    println(left.join(right).collect().mkString(","))
//
    println(left.leftOuterJoin(right).leftOuterJoin(third).collect().mkString(","))
//
//    println(left.rightOuterJoin(right).collect().mkString(","))
  }
}
