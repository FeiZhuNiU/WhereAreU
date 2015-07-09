package com.yu.eric.whereareu;

import android.app.Application;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

/**
 * Created by lliyu on 7/9/2015.
 */
public class LocationApplication extends Application {

    private final String TAG= this.getClass().getSimpleName();

    public LocationClient locationClient;
    public BDLocation bdLocation;
    @Override
    public void onCreate() {
        super.onCreate();
        locationClient = new LocationClient(getApplicationContext());
        locationClient.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                LocationApplication.this.bdLocation =bdLocation;
            }
        });
        LocationClientOption option = new LocationClientOption();
        option.setCoorType("bd09ll");
        option.setScanSpan(2000);
        option.setIsNeedAddress(true);
        locationClient.setLocOption(option);

        Log.i(TAG,"LocationClient Initialized");
    }
}
