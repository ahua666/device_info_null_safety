package com.divit.device_info_null_safety;

import android.content.Context;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.EasySimMod;

public class SimInfo {

private final Context context;

    public SimInfo(Context context) {
        this.context = context;
    }


    public HashMap<String, Object> getSimInfo() {

        EasySimMod easySimMod = new EasySimMod(this.context);

        HashMap<String, Object> result = new HashMap<>();

        result.put("imsi", easySimMod.getIMSI());
        result.put("serial", easySimMod.getSIMSerial());
        result.put("country", easySimMod.getCountry());
        result.put("carrier", easySimMod.getCarrier());
        result.put("isSimNetworkLocked", easySimMod.isSimNetworkLocked());
        result.put("activeMultiSimInfo", easySimMod.getActiveMultiSimInfo());
        result.put("isMultiSim", easySimMod.isMultiSim());
        result.put("numberOfActiveSim", easySimMod.getNumberOfActiveSim());

        return result;
    }


}
