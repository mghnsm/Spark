package bmstu;

public class FlightInfo {
    private String[] str;
    private static final int ORIGIN_AIRPORT_ID = 11;
    private static final int DEST_AIRPORT_ID = 14;
    private static final int ARR_DELAY_NEW = 18;
    private static final int CANCELLED = 19;

    public FlightInfo(String[] str) {
        this.str = str;
    }

    public String getOriginAirportID() {
        return str[ORIGIN_AIRPORT_ID];
    }

    public String getDestAirportID() {
        return str[DEST_AIRPORT_ID];
    }

    public String isCancelled() {
        return str[CANCELLED];
    }

    public String getDelayTime() {
        return str[ARR_DELAY_NEW];
    }
}
