package com.divit.device_info_null_safety;

import android.content.Context;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.EasyLocationMod;

public class LocationInfo {

    private final Context context;

    public LocationInfo(Context context) {
        this.context = context;
    }


    public HashMap<String, Object> getLocationInfo() {
        EasyLocationMod easyLocationMod = new EasyLocationMod(this.context);
        HashMap<String, Object> result = new HashMap<>();
        double[] ll = easyLocationMod.getLatLong();
        result.put("latitude", String.valueOf(ll[0]));
        result.put("longitude", String.valueOf(ll[1]));
        return result;
    }
}
