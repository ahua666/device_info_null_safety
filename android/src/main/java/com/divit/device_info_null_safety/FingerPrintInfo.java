package com.divit.device_info_null_safety;

import android.content.Context;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.EasyFingerprintMod;

public class FingerPrintInfo {


    private  final Context context;

    public FingerPrintInfo(Context context) {
        this.context = context;
    }


    public HashMap<String, Object> getFingerprintInfo() {

        EasyFingerprintMod easyFingerprintMod = new EasyFingerprintMod(this.context);

        HashMap<String, Object> result = new HashMap<>();

        result.put("isFingerprintSensorPresent", easyFingerprintMod.isFingerprintSensorPresent());
        result.put("areFingerprintsEnrolled", easyFingerprintMod.areFingerprintsEnrolled());

        return result;
    }

}
