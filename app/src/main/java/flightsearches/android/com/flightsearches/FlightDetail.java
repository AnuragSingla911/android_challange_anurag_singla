package flightsearches.android.com.flightsearches;

import java.util.ArrayList;

/**
 * Created by jade on 1/4/17.
 */

public class FlightDetail {

    private String originCode;
    private String destinationCode;
    private long departureTime;
    private long arrivalTime;
    private ArrayList<FareProvider> mFareChoices;
    private String airLineCode;
    private String airLineClass;

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public ArrayList<FareProvider> getmFareChoices() {
        return mFareChoices;
    }

    public void setmFareChoices(ArrayList<FareProvider> mFareChoices) {
        this.mFareChoices = mFareChoices;
    }

    public String getAirLineCode() {
        return airLineCode;
    }

    public void setAirLineCode(String airLineCode) {
        this.airLineCode = airLineCode;
    }

    public String getAirLineClass() {
        return airLineClass;
    }

    public void setAirLineClass(String airLineClass) {
        this.airLineClass = airLineClass;
    }
}
