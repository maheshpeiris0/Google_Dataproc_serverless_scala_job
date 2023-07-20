scalaVersion := "2.12.18"
version := "1.0"

name := "hello-world"
organization := "com.example"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.2.3",
  "org.apache.spark" %% "spark-sql" % "3.2.3"
)





