# MPS Data Analysis on Hadoop
This project focuses on analyzing data related to the Metropolitan Police Service (MPS) stops, including various parameters such as the borough of stops, subject's age, gender, ethnic appearance, and more. The analysis is performed using Hadoop, specifically utilizing HDFS for data storage and MapReduce for querying the data. The dataset is processed using Java, and the results are visualized for better understanding and insights.


## Dataset Information

The dataset used in this project contains detailed records of police stops carried out by the Metropolitan Police Service (MPS). Each record captures a variety of attributes that help to analyze and understand the nature of stops and interactions between officers and individuals. Below is a description of the key columns present in the dataset:

- **Date**: The date on which the stop occurred.
- **MPS Area**: The area of the Metropolitan Police Service where the stop took place.
- **Borough of Stop**: The specific borough within London where the stop occurred.
- **Borough Code**: A unique code assigned to each borough.
- **Officer OCU**: The operational unit code of the officer who conducted the stop.
- **Search Type**: The type of search conducted during the stop (e.g., stop and search).
- **Subject**: Indicates the type of subject involved in the stop (e.g., individual stopped).
- **Reason for Stop**: The reason provided for conducting the stop (e.g., suspicion of possession of drugs).
- **Outcome**: The outcome of the stop (e.g., arrest, caution, no further action).
- **Outcome Reason**: The reason for the outcome of the stop, which may provide further context.
- **Apparent Age**: The estimated age of the individual at the time of the stop.
- **Gender**: The gender of the individual stopped.
- **Ethnic Appearance Code**: A code representing the perceived ethnic appearance of the individual.
- **EA Group**: The group classification based on ethnic appearance.
- **Self-defined Ethnicity Code**: A code for the self-reported ethnicity of the individual.
- **SDE Group**: The group classification based on the self-defined ethnicity.
- **Count**: The number of records corresponding to each entry, potentially indicating duplicate entries or data aggregation.


## Technologies Used

- **Hadoop**: For distributed storage and computation using HDFS and MapReduce.
- **Java**: For writing MapReduce programs.
- **Alteryx**: For data preprocessing and visualizations.
- **Maven**: For managing project dependencies.

## Setup Instructions

To set up and run this project, follow these steps:


### 1. Install Hadoop

Ensure you have Hadoop installed on your system. If not, follow the official [Hadoop installation guide](https://youtu.be/kUX6dCbdU3Q?si=uBSnGtiUWLldm1aY) to install Hadoop.

### 2. Set Up HDFS

Before running MapReduce jobs, ensure the data is uploaded to **HDFS**.

#### HDFS Commands:

To interact with HDFS, here are some basic commands:

- **Check HDFS status**:
  ```bash
  hadoop fs -ls /
  ```

- **Upload dataset to HDFS**:
  ```bash
  hadoop fs -put /path/to/local/data.csv /user/hadoop/mps_data/
  ```

- **List files in HDFS directory**:
  ```bash
  hadoop fs -ls /user/hadoop/mps_data/
  ```

- **Remove file from HDFS**:
  ```bash
  hadoop fs -rm /user/hadoop/mps_data/data.csv
  ```

- **View a file in HDFS**:
  ```bash
  hadoop fs -cat /user/hadoop/mps_data/data.csv
  ```

### 3. MapReduce Setup

Ensure that the **MapReduce** job is set up as per the queries you wish to execute. Each query is implemented as a MapReduce job, and you can run them by executing the corresponding `.jar` file.

### 4. Run MapReduce Jobs

To run the MapReduce job, compile your Java code and execute the job with:

```bash
hadoop jar target/BDAMapRedduce-1.0-SNAPSHOT.jar org.bdaproject.DriverClasses.QueryDriver /input/finaldata.csv /output/query
hdfs dfs -cat /output/query/part-r-*
```

### 5. Visualizing Results

After running the MapReduce jobs, the output is stored in the specified output directory in HDFS. You can either:

- Download the output files to your local machine using:
  ```bash
  hadoop fs -get output_path /local_output_path
  ```



## Project Queries

Here are the key MapReduce queries implemented in this project:

1. **Count of Borough Stops**: Calculates the total number of stops in each borough.
2. **Subject Wise Count**: Counts the number of stops by subject type.
3. **Number of Stops by Age Group**: Aggregates the number of stops by different age groups.
4. **Gender Distribution**: Analyzes the distribution of gender in police stops.
5. **Outcomes by Ethnic Appearance**: Counts outcomes based on the ethnic appearance of the subject.
6. **Count by MPS Area**: Computes the total number of stops in each MPS area.
7. **Group by Gender and MPS Area Count**: Groups the data by gender and MPS area to calculate stop counts.
8. **Group by MPS Area and Subject**: Groups the data by MPS area and subject type.
9. **Group by MPS Area and Ethnicity**: Analyzes stops by MPS area and ethnicity.
10. **Group by MPS Area and Average Apparent Age of Subject**: Calculates the average apparent age of individuals stopped in each MPS area.



