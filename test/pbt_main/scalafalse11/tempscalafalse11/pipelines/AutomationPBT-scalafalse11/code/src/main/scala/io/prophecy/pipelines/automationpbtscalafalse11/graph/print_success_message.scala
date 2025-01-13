package io.prophecy.pipelines.automationpbtscalafalse11.graph

import io.prophecy.libs._
import io.prophecy.pipelines.automationpbtscalafalse11.config.Context
import io.prophecy.pipelines.automationpbtscalafalse11.functions.UDFs._
import io.prophecy.pipelines.automationpbtscalafalse11.functions.PipelineInitCode._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object print_success_message {
  def apply(context: Context, in0: DataFrame): DataFrame = {
    val spark = context.spark
    val Config = context.config
    print("Successfully Executed Son.")
    var out0=in0
    out0
  }

}
