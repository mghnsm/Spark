package bmstu;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class SparkApp {

    public static final String PATH_TO_AIRPORT_TABLE = "L_AIRPORT_ID.csv";
    public static final String PATH_TO_FLIGHT_TABLE = "664600583_T_ONTIME_sample.csv";

    private static final String CODE = "Code";
    public static final String DEST_AIRPORT_ID = "DEST_AIRPORT_ID";

    public static final int AIRPORT_ID_TABLE = 0;
    public static final int DEST_AIRPORT_ID_TABLE = 14;

    private static boolean isNotEqualTo(String[] cols, int index, String name) {
        return !cols[index].equals(name);
    }

    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> airport = sc.textFile(PATH_TO_AIRPORT_TABLE);
        JavaRDD<String> flight = sc.textFile(PATH_TO_FLIGHT_TABLE);
        
        JavaRDD<String[]> airportSplitted = airport
                .map(StringSplitter::split)
                .filter(cols -> isNotEqualTo(cols, AIRPORT_ID_TABLE, CODE));

        JavaRDD<String[]> flightSplitted = flight
                .map(StringSplitter::split)
                .filter(cols -> isNotEqualTo(cols, DEST_AIRPORT_ID_TABLE, DEST_AIRPORT_ID));

        JavaPairRDD<Tuple2, FlightDataSerializable> flightPairs = flightSplitted
                .mapToPair(
                        cols -> {
                            FlightInfo data = new FlightInfo(cols);
                            return new Tuple2<>(
                                    new Tuple2(data.getOriginAirportID(), data.getDestAirportID()),
                                    new FlightDataSerializable(data.getDelayTime(), data.isCancelled()));
                        }
                );

        //final Broadcast<Map<String, AirportData>> airportsBroadcasted = sc.broadcast(stringAirportDataMap);
    }

}
