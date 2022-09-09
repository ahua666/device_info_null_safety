package com.divit.device_info_null_safety;

import android.content.Context;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.EasyDisplayMod;

public class DisplayInfo {

    private final Context context;

    public DisplayInfo(Context context) {
        this.context = context;
    }

    public HashMap<String, Object> getDisplayInfo() {

        EasyDisplayMod easyDisplayMod = new EasyDisplayMod(this.context);

        HashMap<String, Object> result = new HashMap<>();

        result.put("resolution", easyDisplayMod.getResolution());
        result.put("density", easyDisplayMod.getDensity());
        //result.put("displayXYCoordinates", easyDisplayMod.getDisplayXYCoordinates());
        result.put("refreshRate", easyDisplayMod.getRefreshRate());
        result.put("physicalSize", easyDisplayMod.getPhysicalSize());

        return result;
    }
}
