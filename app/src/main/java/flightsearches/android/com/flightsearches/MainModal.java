package flightsearches.android.com.flightsearches;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jade on 1/4/17.
 */

public class MainModal {

    private ArrayList<FlightDetail> list = new ArrayList<>();

    private HashMap<String , String> airLines = new HashMap<>();

    private HashMap<String, String> airports = new HashMap<>();

    private HashMap<String, String> providers = new HashMap<>();

    public ArrayList<FlightDetail> getList() {
        return list;
    }

    public void setList(ArrayList<FlightDetail> list) {
        this.list = list;
    }

    public HashMap<String, String> getAirLines() {
        return airLines;
    }

    public void setAirLines(HashMap<String, String> airLines) {
        this.airLines = airLines;
    }

    public HashMap<String, String> getAirports() {
        return airports;
    }

    public void setAirports(HashMap<String, String> airports) {
        this.airports = airports;
    }

    public HashMap<String, String> getProviders() {
        return providers;
    }

    public void setProviders(HashMap<String, String> providers) {
        this.providers = providers;
    }
}
