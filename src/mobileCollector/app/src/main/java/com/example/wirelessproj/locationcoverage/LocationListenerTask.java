package com.example.wirelessproj.locationcoverage;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Message;

//Implementing an instance of the LocationListener class
public class LocationListenerTask implements LocationListener {

    StateChangeHandler m_chngHdlr;
    private static final String TAG = "APP_DEBUG" + LocationListenerTask.class.getSimpleName();

    LocationListenerTask(StateChangeHandler chngHdlr) {
        m_chngHdlr = chngHdlr;
    }

    //Invoked when the location is changed, sets the new location parameters
    public void onLocationChanged(Location location) {
        //Log.d(TAG, "Location changed");
        LocationInfo lInfo = new LocationInfo();
        lInfo.setLongitude(location.getLongitude());
        lInfo.setLatitude(location.getLatitude());
        StateChangeMsg chngMsg = new StateChangeMsg(true);
        chngMsg.setLocationInfo(lInfo);
        Message msg = m_chngHdlr.obtainMessage();
        msg.obj = (Object)chngMsg;
        m_chngHdlr.sendMessage(msg);
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {}

    public void onProviderEnabled(String provider) {}

    public void onProviderDisabled(String provider) {}
}
