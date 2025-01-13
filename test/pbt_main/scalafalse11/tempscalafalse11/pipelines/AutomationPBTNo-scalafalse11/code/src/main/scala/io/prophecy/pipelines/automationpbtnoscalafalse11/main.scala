package io.prophecy.pipelines.automationpbtnoscalafalse11

import io.prophecy.libs._
import io.prophecy.pipelines.automationpbtnoscalafalse11.config._
import io.prophecy.pipelines.automationpbtnoscalafalse11.functions.UDFs._
import io.prophecy.pipelines.automationpbtnoscalafalse11.functions.PipelineInitCode._
import io.prophecy.pipelines.automationpbtnoscalafalse11.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_s3_source_dataset = s3_source_dataset(context)
    create_lookup_table(context, df_s3_source_dataset)
    val df_reformat_customer_data =
      reformat_customer_data(context, df_s3_source_dataset)
    val df_print_success_message =
      print_success_message(context, df_reformat_customer_data)
    val df_SQLStatement_1 = SQLStatement_1(context, df_s3_source_dataset)
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("AutomationPBT-scalafalse11")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/AutomationPBTNo-scalafalse11"
    )
    registerUDFs(spark)
    MetricsCollector.instrument(spark,
                                "pipelines/AutomationPBTNo-scalafalse11"
    ) {
      apply(context)
    }
  }

}
