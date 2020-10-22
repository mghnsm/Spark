package bmstu;

import java.io.Serializable;

public class FlightDataSerializable implements Serializable {
    private int allFlights;
    private int delayedFlights;
    private int cancelledFlights;
    private float maxDelayTime;

    public FlightDataSerializable(int delayedFlights, int cancelledFlights, int allFlights, float maxDelayTime) {
        this.delayedFlights = delayedFlights;
        this.cancelledFlights = cancelledFlights;
        this.allFlights = allFlights;
        this.maxDelayTime = maxDelayTime;
    }

    public int getAllFlights() {
        return allFlights;
    }

    public int getDelayedFlights() {
        return delayedFlights;
    }

    public int getCancelledFlights() {
        return cancelledFlights;
    }

    public float getMaxDelayTime() {
        return maxDelayTime;
    }
}
