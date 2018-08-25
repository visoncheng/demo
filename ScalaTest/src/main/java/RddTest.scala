import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by weicheng on 2018/8/1.
  */
object RddTest {

  def main(args: Array[String]): Unit = {

    var inputPath = "D:\\abc\\Hamlet.txt"

    var sparkConf = new SparkConf().setAppName("RddTest").setMaster("local");
    var sc = new SparkContext(sparkConf)
//    var lines = sc.textFile(inputPath).persist()

/*    var pythonLines = lines.filter(_.contains("python"))*/

//    pythonLines.persist() //这个需要放在行动操作之前，放在行动操作之后的话，会再次运算一次
  /*  pythonLines.foreach(println)
//    pythonLines.persist()
    println(pythonLines.first())
    println(pythonLines.count())*/

   /* var aLines = lines.filter(_.contains("aa"));
    var unionLines = aLines.union(pythonLines)
    unionLines.foreach(println)*/
/*    pythonLines.foreach(println)
    lines.filter(lines => lines.contains("aa") || lines.contains("python")).foreach(println)*/

    //处理集合数据
    var parallLines = sc.parallelize(List(4,5))
//    parallLines.foreach(println)

//    println(parallLines.map(x => x* x).collect().mkString(","))
    println(parallLines.map(x => (x,x)).collect().mkString(","))
//    println("reduce == " + parallLines.reduce((x,y) => x+y))  // 并行整合RDD中的所有数据
    /*var result = parallLines.aggregate((0,0))((a,b)=>(a._1 + b,a._2 + 1),
                          (a,b) => (a._1 + b._1,a._2+ b._2))
    println("a" + result._1 + " b" + result._2)*/


    /*var lines = sc.parallelize(List("hello world","hi","world"))
    val words = lines.flatMap(line => line.split(" "))  //flatMap相当于生成一个一维数组,不会去重
    words.foreach(println)*/
  }

}
