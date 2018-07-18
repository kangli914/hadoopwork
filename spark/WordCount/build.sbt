name := "WordCount"

version := "0.1"

//scalaVersion := "2.11.4"
//scalaVersion := "2.11.12"
//scalaVersion := "2.12.6"
scalaVersion := "2.11.7"


//libraryDependencies += "org.apache.hadoop" % "hadoop-winutils" % "2.4.1"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
//libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.1"
libraryDependencies ++= {
  //val sparkVer = "2.3.1"
  val sparkVer = "2.1.0"
  Seq(
    //"org.apache.spark" %% "spark-core" % sparkVer % "provided" withSources()
    "org.apache.spark" %% "spark-core" % sparkVer % "provided"
  )
}

/*
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}*/
