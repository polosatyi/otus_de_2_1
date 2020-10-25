name := "json_reader_ksalov"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.json4s" %% "json4s-native" % "3.6.10",
  "org.apache.spark" %% "spark-sql" % "2.4.7" % Provided
)
