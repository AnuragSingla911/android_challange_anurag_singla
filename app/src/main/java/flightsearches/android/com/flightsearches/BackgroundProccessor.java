package flightsearches.android.com.flightsearches;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by jade on 1/4/17.
 */

public class BackgroundProccessor extends AsyncTaskLoader<MainModal> {


    private String url = "https://firebasestorage.googleapis.com/v0/b/gcm-test-6ab64.appspot.com/o/ixigoandroidchallenge%2Fsample_flight_api_response.json?alt=media&token=d8005801-7878-4f57-a769-ac24133326d6";
    private Context mContext;
    private MainModal data;
    public BackgroundProccessor(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        if (data != null) {
            deliverResult(data);
        }

        if (data == null || takeContentChanged()) {
            forceLoad();
        }
    }
    @Override
    public MainModal loadInBackground() {

        JsonObjectRequest req = new JsonObjectRequest(url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        FlightListParser parser = new FlightListParser();
                        data = parser.parseFlightDetail(response);
                        deliverResult(data);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }

        });
        VolleyController.getInstance(mContext).addToRequestQueue(req);
        return null;
    }
}
