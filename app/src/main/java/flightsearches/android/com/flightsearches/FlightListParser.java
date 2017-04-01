package flightsearches.android.com.flightsearches;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by jade on 1/4/17.
 */

public class FlightListParser {

    public MainModal parseFlightDetail(JSONObject object){
        MainModal modal = new MainModal();
        JSONArray flightList = object.optJSONArray("flights");
        if(flightList != null && flightList.length() > 0){
            ArrayList<FlightDetail> list = new ArrayList<>();
            for(int i =0; i< flightList.length() ; i++){
                JSONObject jsonObject = flightList.optJSONObject(i);
                if(jsonObject != null){
                    FlightDetail detail = new FlightDetail();
                    detail.setOriginCode(jsonObject.optString("originCode"));
                    detail.setDestinationCode(jsonObject.optString("destinationCode"));
                    detail.setDepartureTime(jsonObject.optLong("departureTime"));
                    detail.setArrivalTime(jsonObject.optLong("arrivalTime"));
                    JSONArray array = jsonObject.optJSONArray("fares");
                    detail.setmFareChoices(parseFareChoices(array));
                    detail.setAirLineCode(jsonObject.optString("airlineCode"));
                    detail.setAirLineClass(jsonObject.optString("class"));
                    list.add(detail);
                }
            }
            modal.setList(list);
        }

        JSONObject appendics = object.optJSONObject("appendix");
        JSONObject airlines = appendics.optJSONObject("airlines");
        if(airlines != null){
            HashMap<String, String> airLinesCodes = new HashMap<>();
            Iterator<String> keys = airlines.keys();
            while(keys.hasNext()){
                String key = keys.next();
                airLinesCodes.put(key , airlines.optString(key));
            }
            modal.setAirLines(airLinesCodes);
        }

        JSONObject airPorts = appendics.optJSONObject("airports");
        if(airPorts != null){
            HashMap<String, String> airPortsCode = new HashMap<>();
            Iterator<String> keys = airPorts.keys();
            while(keys.hasNext()){
                String key = keys.next();
                airPortsCode.put(key , airPorts.optString(key));
            }
            modal.setAirports(airPortsCode);
        }

        JSONObject providers = appendics.optJSONObject("providers");
        if(airlines != null){
            HashMap<String, String> providerCode = new HashMap<>();
            Iterator<String> keys = providers.keys();
            while(keys.hasNext()){
                String key = keys.next();
                providerCode.put(key , providers.optString(key));
            }
            modal.setProviders(providerCode);
        }


        return modal;
    }

    private ArrayList<FareProvider> parseFareChoices(JSONArray array){
        if(array != null && array.length() > 0){
            ArrayList<FareProvider> choices = new ArrayList<>();
            for(int i =0; i< array.length() ; i++){
                JSONObject object = array.optJSONObject(i);
                if(object != null){
                    FareProvider provider = new FareProvider();
                    provider.setFare(object.optInt("fare"));
                    provider.setProviderID(object.optInt("providerId"));
                    choices.add(provider);
                }
            }
            return choices;
        }
        return null;
    }
}
