# Spark Programming

Going through the setup, Spark programming stuff 

## Setup and facing issues and  more Notes

Notes and instructions on setting up a full functioning development enviroment is as belows

### Prerequisites

What things are needed to install to setup a full development enviroments including Hadoop clusters

* IDE: Intellij and Scala plugins 
* Build Dependency tool: SBT 
* Docker version of Hortenwork HDP Sandbox: Spark Cluster running over on Hadoop YARN

Using [WordCount](https://github.com/kangli914/hadoopwork/tree/master/spark/WordCount) as an example here:


####  Resolution:
Remove "provided" and ran sbt clean, reload, compile, package, run 
```
Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/spark/SparkConf
	at main.scala.Main$.main(Main.scala:10)
	at main.scala.Main.main(Main.scala)
	Caused by: java.lang.ClassNotFoundException: org.apache.spark.SparkConf
```

####  Resolution:
Download the corresponding Hadoop version's winutils.exe into %HADOOP_HOME%\bin\. Either environment variable HADOOP_HOME is set, or -Dhadoop.home.dir=xxx is passed to the java application.
e.g. Set "-Dhadoop.home.dir=C:\\Temp\\hadoop_winutils\\" as VM options in Intellij and then put downloaded "winutils.exe" in C:\Temp\hadoop_winutils\bin
```
WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
ERROR Shell: Failed to locate the winutils binary in the hadoop binary path
java.io.IOException: Could not locate executable null\bin\winutils.exe in the Hadoop binaries.
	at org.apache.hadoop.util.Shell.getQualifiedBinPath(Shell.java:378)
```

## Good References

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

