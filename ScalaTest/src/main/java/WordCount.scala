import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by weicheng on 2018/7/27.
  */
object WordCount {
  def main(args: Array[String]) {
//    var hadoop = System.getProperty("hadoop.home.dir")
//    System.setProperty("hadoop.home.dir", "D:\\software\\hadoop-2.8.4\\bin\\winutils.exe")
    var masterUrl = "local"
    var inputPath = "/home/cheng/demo/Hamlet.txt"
    var outputPath = "/home/cheng/demo/output"

    if (args.length == 1) {
      masterUrl = args(0)
    } else if (args.length == 3) {
      masterUrl = args(0)
      inputPath = args(1)
      outputPath = args(2)
    }

    println(s",masterUrl:${masterUrl}, inputPath: ${inputPath}, outputPath: ${outputPath}")

    val sparkConf = new SparkConf().setAppName("WordCount").setMaster(masterUrl)
    val sc = new SparkContext(sparkConf)

    val rowRdd = sc.textFile(inputPath)
    val resultRdd = rowRdd.flatMap(line => line.split("\\s+"))
      .map(word => (word, 1)).reduceByKey(_ + _)

    resultRdd.saveAsTextFile(outputPath)
  }
}
