package bmstu;

public class AirportInfo {
    private String[] str;
    private static final int AIRPORT_ID = 0;
    private static final int AIRPORT_NAME = 1;

    private int airportNameEnd = str.length - 1;

    public AirportInfo(String[] str) {
        this.str = str;
    }

    public String getAirportID() {
        return str[AIRPORT_ID];
    }

    public String getAirportName() {
        String out = "";
        for(int i = AIRPORT_NAME; i < airportNameEnd; i++) {
            out += str[i];
        }
        return out;
    }
}
