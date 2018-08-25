package sparksql

import org.apache.spark.sql.SparkSession

/**
  * Created by weicheng on 2018/8/8.
  */
object SparkSqlTest {
  def main(args: Array[String]): Unit = {
    var spark = SparkSession.builder()
      .appName("sparkSql")
      .master("local")
      .getOrCreate()
    var sc = spark.sparkContext

    //从json中读取数据
   /* var jsonPath = "D:\\manage\\moduca\\players.json"
    var players = spark.read.json(jsonPath)*/
   /* //显示全部列
    players.show()
    //显示列名字为name的数据
    players.select("name").show()*/

    //SparkSession用户可以像SQLContext一样使用Spark SQL的全部功能
   /* players.createOrReplaceTempView("players")
    var result = spark.sql("select test.b from players where test.a='12'")
    result.show(2)*/

    spark.udf.register("contact_name",(str:String) => {
      "aaa" + str
    })

    var happyPersonRdd = sc.parallelize(List(HappyPerson("holden","conffee"),
                                            HappyPerson("yushen","tea")))
    var happyPersonDf = spark.createDataFrame(happyPersonRdd)
    happyPersonDf.createOrReplaceTempView("happy_people")
    var result = spark.sql("select contact_name(handler),favoriteBeverage from happy_people")
    result.show()

  }

  case class HappyPerson(handler: String, favoriteBeverage: String)
}
