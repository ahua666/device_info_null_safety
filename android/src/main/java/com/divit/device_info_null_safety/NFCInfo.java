package com.divit.device_info_null_safety;

import android.content.Context;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.EasyNfcMod;

public class NFCInfo {

    private final Context context;

    public NFCInfo(Context context) {
        this.context = context;
    }

    public HashMap<String, Object> getNfcInfo() {

        EasyNfcMod easyNfcMod = new EasyNfcMod(this.context);

        HashMap<String, Object> result = new HashMap<>();

        result.put("isNfcPresent", easyNfcMod.isNfcPresent());
        result.put("isNfcEnabled", easyNfcMod.isNfcEnabled());

        return result;
    }
}
