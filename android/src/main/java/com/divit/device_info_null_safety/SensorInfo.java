package com.divit.device_info_null_safety;

import android.content.Context;
import android.hardware.Sensor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import github.nisrulz.easydeviceinfo.base.EasySensorMod;

public class SensorInfo {

    private final Context context;

    public SensorInfo(Context context) {
        this.context = context;
    }


    public List<HashMap<String, Object>> getSensorInfo() {

        EasySensorMod easySensorMod = new EasySensorMod(this.context);

        List<HashMap<String, Object>> result = new ArrayList<>();

        List<Sensor> sensors = easySensorMod.getAllSensors();

        for (Sensor sensor : sensors) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("name", sensor.getName());
            data.put("vendor", sensor.getVendor());
            data.put("version", sensor.getVersion());
            data.put("power", sensor.getPower());
            data.put("resolution", sensor.getResolution());
            data.put("maximumRange", sensor.getMaximumRange());
            result.add(data);
        }

        return result;
    }
}
