package com.example

import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.sql.types.{StructType, StructField, StringType, IntegerType}


object Main{
    def main(args: Array[String]): Unit = {
        println("Hello, world!")
        val spark = SparkSession.builder().appName("Hello World").master("local").getOrCreate()

        // Create schema for the DataFrame
        val schema = StructType(
        Array(
            StructField("Name", StringType, nullable = false),
            StructField("Age", IntegerType, nullable = false)
        )
        )

        // Create data for the DataFrame
        val data = Seq(
        ("John", 30),
        ("Alice", 25),
        ("Bob", 35)
        )

        // Create DataFrame from the data and schema
        val df: DataFrame = spark.createDataFrame(data).toDF(schema.fieldNames: _*)

        // Show the DataFrame
        df.show()

        val filePath = "gs://bucket" // Path to the CSV file in GCS
        val df_1: DataFrame = spark.read
        .option("header", "true")  // Assuming the file has a header row
        .option("inferSchema", "true")
        .csv(filePath)

        // Show the DataFrame
        df_1.show()

         // Write DataFrame to BigQuery
        val projectID = "project" // Replace with your project ID
        val datasetID = "test_table" // Replace with your dataset ID
        val tableID = "crab_data"
        val tableFullyQualifiedID = s"$projectID.$datasetID.$tableID"
        // need to create a bucket in GCS to store temp data for BigQuery -mp_backup_data
        df_1.write.format("bigquery").option("temporaryGcsBucket","mp_backup_data").option("table", tableFullyQualifiedID).mode("overwrite").save()


    }
}