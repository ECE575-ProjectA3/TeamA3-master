package com.example.wirelessproj.locationcoverage;

//Triggers a change of state message wen either the signal strength or location parameters have changed
public class StateChangeMsg {
    boolean m_isLocationChanged;
    LocationInfo m_linfo = null;
    CoverageInfo m_cinfo = null;

    public StateChangeMsg(boolean isLocationChanged) {
        m_isLocationChanged = isLocationChanged;
    }

    public boolean isLocationChanged() {
        return m_isLocationChanged;
    }

    public void setLocationInfo(LocationInfo lInfo) {
        m_linfo = lInfo;
    }

    public void setCoverageInfo(CoverageInfo cInfo) {
        m_cinfo = cInfo;
    }

    public LocationInfo getLocationInfo() {
        return m_linfo;
    }

    public CoverageInfo getCoverageInfo() {
        return m_cinfo;
    }
}
