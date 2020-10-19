package bmstu;

public class SparkApp {
    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext(conf);
    }
}
