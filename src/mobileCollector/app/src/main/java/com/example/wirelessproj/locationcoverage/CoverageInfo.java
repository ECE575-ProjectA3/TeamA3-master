package com.example.wirelessproj.locationcoverage;

//Assigning and extracting signal strength values
public class CoverageInfo {

    int m_signalStrengthLevel;
    String m_networkProviderName;

    public void setSignalStrengthLevel(int level) {
        m_signalStrengthLevel = level;
    }

    public void setNetworkProviderName(String name) {
        m_networkProviderName = name;
    }

    public int getSignalStrengthLevel() {
        return m_signalStrengthLevel;
    }

    public String getNetworkProviderName() { return m_networkProviderName;}

    //Checking if the signal strength has changed
    public boolean isChanged(CoverageInfo rhs) {
        if (rhs == null) {
            return true;
        }
        if (m_signalStrengthLevel != rhs.m_signalStrengthLevel) {
            return true;
        }
        return false;
    }
}
