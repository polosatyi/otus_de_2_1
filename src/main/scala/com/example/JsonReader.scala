package com.example

import org.apache.spark.sql.SparkSession
import org.json4s.native.JsonMethods.parse
import org.json4s.DefaultFormats


object JsonReader extends App {

  override def main(args: Array[String]): Unit = {

    if (args.length != 1) {
      throw new Exception(
        "You must pass an argument: {path/to/winemag.json}"
      )
    }

    val spark = SparkSession
      .builder()
      .appName("JsonReader")
      .master("local[*]")
      .getOrCreate()

    val inputFilePath = args(0)

    val sc = spark.sparkContext

    sc.textFile(inputFilePath)
      .map(item => {
        implicit val jsonDefaultFormats: DefaultFormats = DefaultFormats;
        parse(item).extract[Wine]
      }).foreach(println)

    sc.stop()

  }

}
