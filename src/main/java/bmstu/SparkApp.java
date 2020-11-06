package bmstu;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class SparkApp {

    public static final String PATH_TO_AIRPORT_TABLE = "L_AIRPORT_ID.csv";
    public static final String PATH_TO_FLIGHT_TABLE = "664600583_T_ONTIME_sample.csv";

    private static final String code = "Code";

    private static boolean isNotEqualTo(String cols, int index, String name) {
        return !cols[index]
    }

    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> dict = sc.textFile(PATH_TO_AIRPORT_TABLE);
        JavaRDD<String> time = sc.textFile(PATH_TO_FLIGHT_TABLE);
        //JavaRDD<String> dictSplitted = dict.flatMap(s -> Arrays.stream(s.split(",")).iterator());
        //JavaRDD<String> timeSplitted = time.flatMap(s -> Arrays.stream(s.split(",")).iterator());

        JavaRDD<String[]> dictSplitted = dict
                .map(StringSplitter::split)
                .filter();

        JavaRDD<String[]> timeSplitted = time
                .map(StringSplitter::split)
                .filter();

        //final Broadcast<Map<String, AirportData>> airportsBroadcasted = sc.broadcast(stringAirportDataMap);
    }

}
