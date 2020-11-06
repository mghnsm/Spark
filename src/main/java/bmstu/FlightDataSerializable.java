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

    public FlightDataSerializable(String delay, String cancelled) {
        if (delay.equals("")) {
            this.maxDelayTime = 0;
            this.delayedFlights = 0;
        } else {
            this.maxDelayTime = Float.parseFloat(delay);
            this.delayedFlights = (maxDelayTime > 0 ? 1 : 0);
        }
        this.allFlights = 1;
        this.cancelledFlights = (Float.parseFloat(cancelled) > 0 ? 1 : 0);
    }

    public static FlightDataSerializable addData(FlightDataSerializable first, FlightDataSerializable second) {
        return new FlightDataSerializable(
                first.getDelayedFlights() + second.getDelayedFlights(),
                first.getCancelledFlights() + second.getCancelledFlights(),
                first.getAllFlights() + second.getAllFlights(),
                Math.max(first.getMaxDelayTime(), second.getMaxDelayTime())
        );
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

    public float getDelaysPercent() {

    }

    public float getCancelledPercent() {

    }
}
