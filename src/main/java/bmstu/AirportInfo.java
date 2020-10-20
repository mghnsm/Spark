package bmstu;

public class AirportInfo {
    private String[] str;
    private static final int AIRPORT_ID = 0;
    private static final int AIRPORT_NAME = 1;

    public AirportInfo(String[] str) {
        this.str = str;
    }

    public String getAirportID() {
        return str[AIRPORT_ID];
    }

    public String getAirportName() {
        return str[AIRPORT_NAME];
    }
}
