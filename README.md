# hadoopwork
Spark notes:
- Architecture
![alt](https://github.com/kangli914/hadoopwork/blob/master/spark/spark_architecture_notesadded.png "Spark running in Hadoop clusters managed by YARN")
- Concepts:<br/>
RDD Characteristics:
1) RDDs are partitioned: RDDs are not collections on a single machine,the entire contents of an RDD are split accorss multiple worker nodes in the spark cluster. Say you have RDD holding the a table below, the content of this RDD is entirely held in memory accorss multiple nodes
2) RDDs are immutable: once it created it can not be changed. Only two operations are permitted on RDD: Transformation and Action (any request to yeild results on RDD)
3) RDDs are resilient to node failures: if a node which holds an RDD crashes, that RDD can be reconstructed from RAW form.
4) RDDs are stored in memory for every node in the cluster not on disk (e.g. hdfs)
