package com.yu.eric.whereareu;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.mapapi.map.MapView;


public class MainActivity extends ActionBarActivity {

    private final String TAG= this.getClass().getSimpleName();

    private TextView textView_location;
    private TextView textView_refreshTime;
    private MapView mapView;
    private Button button_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        textView_location = (TextView) findViewById(R.id.locationText);
        textView_refreshTime = (TextView) findViewById(R.id.updateTimeText);
        mapView = (MapView) findViewById(R.id.bmapView);
        button_start = (Button) findViewById(R.id.startButton);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button_start.getText().equals("START")){
                    ((LocationApplication)getApplication()).locationClient.start();
                    button_start.setText("STOP");
                }else{
                    ((LocationApplication)getApplication()).locationClient.stop();
                    button_start.setText("START");
                }
            }
        });
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
}
