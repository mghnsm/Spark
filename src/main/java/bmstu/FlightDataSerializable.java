package bmstu;

import java.io.Serializable;

public class FlightDataSerializable implements Serializable {
    private int allFlights;
    private int delayedFlights;
    private int cancelledFlights;
    private float maxDelayTime;
    
    public FlightDataSerializable() {

    }
}
