package bmstu;

public class AirportInfo {
    private String[] str;
    private int 

    public AirportInfo(String[] str) {
        this.str = str;
    }

    public String getAirportID() {
        return str[0];
    }

    public String getAirportName() {
        return str[1];
    }
}
