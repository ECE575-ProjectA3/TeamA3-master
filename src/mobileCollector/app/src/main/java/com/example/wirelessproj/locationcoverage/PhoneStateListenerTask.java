package com.example.wirelessproj.locationcoverage;

import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Implementing an instance of the PhoneStateListener class
public class PhoneStateListenerTask extends PhoneStateListener {

    TelephonyManager mTmngr;
    StateChangeHandler m_chngHdlr;
    private static final String TAG = "APP_DEBUG" + PhoneStateListenerTask.class.getSimpleName();

    PhoneStateListenerTask(TelephonyManager tMngr,StateChangeHandler chngHdlr) {
        mTmngr = tMngr;
        m_chngHdlr = chngHdlr;
    }

    @Override
    //Invoked when there has been a change in the signal strength
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);

        //Log.d(TAG, "Coverage has changed");
        CoverageInfo cInfo = new CoverageInfo();
        cInfo.setNetworkProviderName(mTmngr.getNetworkOperatorName());
        StateChangeMsg chngMsg = new StateChangeMsg(false);
        chngMsg.setCoverageInfo(cInfo);
        Message msg = m_chngHdlr.obtainMessage();
        msg.obj = (Object)chngMsg;

        //Checking if the network type is LTE
        if (mTmngr.getNetworkType() == 13) {
            // Reflection code starts from here
            // copy pasted from http://www.truiton.com/2014/08/android-onsignalstrengthschanged-lte-strength-measurement/
            try {
                Method[] methods = android.telephony.SignalStrength.class.getMethods();
                for (Method mthd : methods) {
                    /*if (mthd.getName().equals("getLteSignalStrength")
                            || mthd.getName().equals("getLteRsrp")
                            || mthd.getName().equals("getLteRsrq")
                            || mthd.getName().equals("getLteRssnr")
                            || mthd.getName().equals("getLteCqi")) {
                        Log.d(TAG,
                                "onSignalStrengthsChanged: " + mthd.getName() + " "
                                        + mthd.invoke(signalStrength));
                    }*/
                    if (mthd.getName().equals("getLteSignalStrength")) {
                        int signalLevel = (Integer)mthd.invoke(signalStrength);
                        //Divided by 8 to sort them into ranges of low, medium and high signal strength
                        cInfo.setSignalStrengthLevel(signalLevel/8);
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        m_chngHdlr.sendMessage(msg);
    }
}
