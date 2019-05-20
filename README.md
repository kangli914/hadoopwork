# Hadoop work and notes
My work and note stuff including Hadoop ecosystem

## Hadoop notes:
Verious note on Hadoop performance aspects
### 
Hadoop use resource schedulers to allocate the resources among the multiple tenants of a Hadoop cluster. Hadoop resource schedulers are components that are responsible for assigning tasks to available YARN containers (e.g Memory & CPU cores) on various DataNodes. The scheduler is a plug-in within the Resource Manager.
Hadoop comes with three different types of resource schedulers.
* FIFO Scheduler: a single queue for all jobs. There’s no concept of priority in choosing a job for execution, with the oldest jobs getting chosen first from the head of the queue.
* Capacity Scheduler: it uses dedicated queues to which you assign jobs. Each queue has a predetermined amount of resources allocated to it. It guarantees minimum capacity levels for all of a cluster’s job queues. If there’s any unused capacity left over from a job queue, the scheduler makes the excess capacity available to queues that are overloaded, thus optimizing the usage of a cluster’s resources.
 
 
 
## Spark notes:
Spark on distributed mode on the Hadoop cluster managed by YARN as cluster manager. In the cluster, there is a master and x number of workers. YARN became the sub-project of Hadoop in the year 2012. It is also known as MapReduce 2.0.
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

### Miscellaneous Notes
![alt](https://github.com/kangli914/hadoopwork/blob/master/spark/note.jpg "note")