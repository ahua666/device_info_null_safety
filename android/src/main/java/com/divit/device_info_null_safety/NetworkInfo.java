package com.divit.device_info_null_safety;

import android.content.Context;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.EasyNetworkMod;
import github.nisrulz.easydeviceinfo.base.NetworkType;

public class NetworkInfo {


    private final Context context;


    public NetworkInfo(Context context) {
        this.context = context;
    }


    public HashMap<String, Object> getNetworkInfo() {

        EasyNetworkMod easyNetworkMod = new EasyNetworkMod(this.context);

        HashMap<String, Object> result = new HashMap<>();

        result.put("isNetworkAvailable", easyNetworkMod.isNetworkAvailable());
        result.put("isWifiEnabled", easyNetworkMod.isWifiEnabled());
        result.put("iPv4Address", easyNetworkMod.getIPv4Address());
        result.put("iPv6Address", easyNetworkMod.getIPv6Address());
        result.put("wifiSSID", easyNetworkMod.getWifiSSID());
        result.put("wifiBSSID", easyNetworkMod.getWifiBSSID());
        result.put("wifiLinkSpeed", easyNetworkMod.getWifiLinkSpeed());
        result.put("wifiMAC", easyNetworkMod.getWifiMAC());

        @NetworkType
        int networkType = easyNetworkMod.getNetworkType();
        switch (networkType) {
            case NetworkType.CELLULAR_UNKNOWN:
                result.put("networkType", "Unknown");
                break;
            case NetworkType.CELLULAR_UNIDENTIFIED_GEN:
                result.put("networkType", "Cellular Unidentified Generation");
                break;
            case NetworkType.CELLULAR_2G:
                result.put("networkType", "Cellular 2G");
                break;
            case NetworkType.CELLULAR_3G:
                result.put("networkType", "Cellular 3G");
                break;
            case NetworkType.CELLULAR_4G:
                result.put("networkType", "Cellular 4G");
                break;
            case NetworkType.WIFI_WIFIMAX:
                result.put("networkType", "WIFI/WIFIMAX");
                break;
            case NetworkType.UNKNOWN:

        }
        return result;
    }
}
