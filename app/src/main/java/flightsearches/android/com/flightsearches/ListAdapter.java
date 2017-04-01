package flightsearches.android.com.flightsearches;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by jade on 1/4/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private MainModal data;
    private Context mContext;

    public ListAdapter(Context context , MainModal modal){
        mContext = context;
        data = modal;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item , parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FlightDetail detail = data.getList().get(position);
        holder.mFlightName.setText(data.getAirLines().get(detail.getAirLineCode()));
        holder.mFlightClass.setText(detail.getAirLineClass());
        holder.mStartTime.setText(getDate(detail.getDepartureTime()));
        holder.mEndTime.setText(getDate(detail.getArrivalTime()));
        holder.mStartCity.setText(data.getAirports().get(detail.getOriginCode()));
        holder.mEndCity.setText(data.getAirports().get(detail.getDestinationCode()));
        for(FareProvider info : detail.getmFareChoices()){
            TextView infoView = new TextView(mContext);
            String infoViewStr = data.getProviders().get(""+info.getProviderID()) +
                    " providing flight with Rs." + info.getFare();
            infoView.setText(infoViewStr);
            holder.mProviders.addView(infoView);
        }
    }

    private String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time);
        String date = DateFormat.format("yyyy-MM-dd HH:mm:ss", cal).toString();
        return date;
    }

    @Override
    public int getItemCount() {
        return data != null && data.getList() != null ? data.getList().size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mFlightName;
        private TextView mFlightClass;
        private TextView mStartTime;
        private TextView mEndTime;
        private TextView mStartCity;
        private TextView mEndCity;
        private LinearLayout mProviders;

        public ViewHolder(View itemView) {
            super(itemView);
            mFlightName = (TextView)itemView.findViewById(R.id.airLine);
            mFlightClass = (TextView)itemView.findViewById(R.id.airLineClass);
            mStartTime = (TextView)itemView.findViewById(R.id.startTime);
            mEndTime = (TextView)itemView.findViewById(R.id.endTime);
            mStartCity = (TextView)itemView.findViewById(R.id.startCity);
            mEndCity = (TextView)itemView.findViewById(R.id.endCity);
            mProviders = (LinearLayout)itemView.findViewById(R.id.providers);
        }
    }
}
