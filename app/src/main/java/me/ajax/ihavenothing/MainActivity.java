package me.ajax.ihavenothing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int mAllOffsetY;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mAllOffsetY += dy;


                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                for (int i = 0; i < recyclerView.getChildCount(); i++) {
                    if (i != 0) {
                        View view = recyclerView.getChildAt(i);
                        if (view != null) {
                            view.setScaleX(1F);
                            view.setScaleY(1F);
                        }
                    }
                }

                View view = recyclerView.getChildAt(0);
                if (view != null
                        && recyclerView.getChildLayoutPosition(view) == layoutManager.findFirstVisibleItemPosition()) {

                    float viewHeight = (float) view.getMeasuredHeight();
                    float faction = mAllOffsetY % viewHeight / viewHeight;

                    faction = 1 - 0.5f * faction;
                    l(mAllOffsetY, dy, view.getMeasuredHeight(), faction, layoutManager.findFirstVisibleItemPosition());
                    view.setScaleY(faction);
                    view.setScaleX(faction);
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cardAdapter = new CardAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    static void l(Object... list) {
        StringBuilder text = new StringBuilder();
        for (Object o : list) {
            text.append("   ").append(o.toString());
        }
        Log.e("######", text.toString());
    }
}
