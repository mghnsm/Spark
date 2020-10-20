package bmstu;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class SparkApp {
    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> dict = sc.textFile("L_AIRPORT_ID.csv");
        JavaRDD<String> time = sc.textFile("664600583_T_ONTIME_sample.csv");
        JavaRDD<String> dictSplitted = dict.flatMap(s -> Arrays.stream(s.split(",")).iterator());
        JavaRDD<String> timeSplitted = time.flatMap(s -> Arrays.stream(s.split(",")).iterator());

        final Broadcast<Map<String, AirportData>> airportsBroadcasted = sc.broadcast(stringAirportDataMap);
    }
}
