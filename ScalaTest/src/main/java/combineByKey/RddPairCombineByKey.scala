package combineByKey

import org.apache.spark.{SparkConf, SparkContext}


/**
  * 理解combineByKey
  *
  * https://www.jianshu.com/p/d7552ea4f882
  *
  * @author Patrick.ho
  *
  */


object RddPairCombineByKey {
    def printValue(obj : (String, Juice)) = {
        println(obj._1 + "==" + obj._2.volumn);
    }
    def main(args: Array[String]): Unit = {

        val conf = new SparkConf().setMaster("local").setAppName("My app");
        val sc = new SparkContext(conf);


        val apple1 = new Fruit("apple", 5)
        val apple2 = new Fruit("apple", 8)
        val orange1 = new Fruit("orange", 10)

        val fruit = sc.parallelize(List(("apple", apple1), ("orange", orange1), ("apple", apple2)))
        /**
          * 第一个函数，每一个分区第一次出现各个键的时候执行
          * 第二个函数，在处理当前分区之前遇到过的键的时候执行
          * 第三个函数，不同分区有对应同一个键的时候执行
          */


        val juice = fruit.combineByKey(
            f => f.makeJuice,
            (j: Juice, f) => j.add(f.makeJuice),
            (j1: Juice, j2: Juice) => j1.add(j2)
        )

        juice.collect().foreach(printValue)

    }
}
