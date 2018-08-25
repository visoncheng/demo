import org.apache.spark.SparkConf
import org.apache.spark.sql.catalyst.expressions.Second
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by weicheng on 2018/7/31.
  */
object SparkStreamingTest {

  def main(args: Array[String]): Unit = {

    var conf = new SparkConf().setMaster("local").setAppName("NetworkWordCount")

    var ssc = new StreamingContext(conf,Seconds(1))

    var lines = ssc.socketTextStream("localhost",9999)

    val words = lines.flatMap(_.split(" "))

    val pairs = words.map(word => (word,1))

    val wordCounts = pairs.reduceByKey(_+_)

    wordCounts.print()
  }
}
