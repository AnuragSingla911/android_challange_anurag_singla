package flightsearches.android.com.flightsearches;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this , LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        getSupportLoaderManager().initLoader(2, null, new LoaderManager.LoaderCallbacks<MainModal>() {
            @Override
            public Loader<MainModal> onCreateLoader(int id, Bundle args) {
                return new BackgroundProccessor(MainActivity.this);
            }

            @Override
            public void onLoaderReset(Loader<MainModal> loader) {

            }

            @Override
            public void onLoadFinished(Loader<MainModal> loader, MainModal data) {
                mRecyclerView.setAdapter(new ListAdapter(MainActivity.this , data));
            }
        });
    }
}
