# Hadoop work and notes
My work and note stuff including Hadoop ecosystem
 
## Spark notes:
### Architecture
![alt](https://github.com/kangli914/hadoopwork/blob/master/spark/spark_architecture_notesadded.png "Spark running in Hadoop clusters managed by YARN")

### Concepts
#### RDD Characteristics:
* RDDs are partitioned: RDDs are not collections on a single machine,the entire contents of an RDD are split accorss multiple worker nodes in the spark cluster.
say you have RDD holding the a table below, the content of this RDD is entirely held in memory accorss multiple nodes
![alt](https://github.com/kangli914/hadoopwork/blob/master/spark/RDD.png "RDD")
* RDDs are immutable: once it created it can not be changed. Only two operations are permitted on RDD: Transformation and Action (any request to yeild results on RDD)
* RDDs are resilient to node failures: if a worker node which holds an RDD crashes, that RDD can be reconstructed from RAW form.
* RDDs are stored in memory for every node in the cluster not on disk (e.g. hdfs)

#### DAG, Lineage for RDD Action and Transformation:
* All the transformation on the dataset are set up as a directed acyclic graph (DAG). The nodes in the graphs are the actual operations performed on the data. Once we have this DAG setup, when an actions is requested, Spark can efficiently compute the best possible way to process the data, execute operation in parallel, and return the result to the user.
* The chain of transformations are tracked in medtadata by the Spark. This is called the lineage of an RDD. Every RDD in Spark is aware of its own lineage back to the original so RDD can be re-constructed by lineage medtadata.

#### Difference of Dataset and Dataframe: ( very confused here!!!)
* Spark2 unified the APIs
* Dataframe = Dataset[Row]
![alt](https://github.com/kangli914/hadoopwork/blob/master/spark/dataframe_dataset.png "dataset")