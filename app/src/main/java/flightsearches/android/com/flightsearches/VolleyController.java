package flightsearches.android.com.flightsearches;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by jade on 1/4/17.
 */

public class VolleyController {

    private static final String TAG = "volley";
    private VolleyController(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }
    private RequestQueue mRequestQueue;
    private static VolleyController mINSTANCE;
    public static VolleyController getInstance(Context context){
        if(mINSTANCE == null){
            synchronized (VolleyController.class){
                if(mINSTANCE == null){
                    mINSTANCE = new VolleyController(context);
                }
            }
        }
        return mINSTANCE;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        mRequestQueue.add(req);
    }

    public void cancelPendingRequests() {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(TAG);
        }
    }
}
