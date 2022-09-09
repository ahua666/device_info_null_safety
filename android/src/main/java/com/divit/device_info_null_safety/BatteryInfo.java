package com.divit.device_info_null_safety;

import android.annotation.SuppressLint;
import android.content.Context;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.BatteryHealth;
import github.nisrulz.easydeviceinfo.base.ChargingVia;
import github.nisrulz.easydeviceinfo.base.EasyBatteryMod;

public class BatteryInfo {

    private  final Context context;

    public BatteryInfo(Context context) {
        this.context = context;
    }

    public HashMap<String, Object> getBatteryInfo() {

        EasyBatteryMod easyBatteryMod = new EasyBatteryMod(this.context);

        HashMap<String, Object> result = new HashMap<>();

        result.put("batteryPercentage", easyBatteryMod.getBatteryPercentage());
        result.put("isDeviceCharging", easyBatteryMod.isDeviceCharging());
        result.put("batteryTechnology", String.valueOf(easyBatteryMod.getBatteryTechnology()));
        result.put("batteryTemperature", easyBatteryMod.getBatteryTemperature());
        result.put("batteryVoltage", easyBatteryMod.getBatteryVoltage());
        result.put("isBatteryPresent", easyBatteryMod.isBatteryPresent());

        @BatteryHealth
        int batteryHealth = easyBatteryMod.getBatteryHealth();
        switch (batteryHealth) {
            case BatteryHealth.GOOD:
                result.put("batteryHealth", "Good");
                break;
            case BatteryHealth.HAVING_ISSUES:
                result.put("batteryHealth", "Having issues");
                break;
        }

        @SuppressLint("WrongConstant") @ChargingVia
        int isChargingVia = easyBatteryMod.getChargingSource();
        switch (isChargingVia) {
            case ChargingVia.AC:
                result.put("chargingSource", "AC");
                break;
            case ChargingVia.USB:
                result.put("chargingSource", "USB");
                break;
            case ChargingVia.WIRELESS:
                result.put("chargingSource", "Wireless");
                break;
            case ChargingVia.UNKNOWN_SOURCE:
            default:
                result.put("chargingSource", "-");
                break;
        }

        return result;
    }
}
