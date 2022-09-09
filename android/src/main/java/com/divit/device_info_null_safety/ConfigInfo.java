package com.divit.device_info_null_safety;

import android.content.Context;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.EasyConfigMod;
import github.nisrulz.easydeviceinfo.base.RingerMode;

public class ConfigInfo {


    private final Context context;

    public ConfigInfo(Context context) {
        this.context = context;
    }

    public HashMap<String, Object> getConfigInfo() {

        EasyConfigMod easyConfigMod = new EasyConfigMod(this.context);

        HashMap<String, Object> result = new HashMap<>();

        result.put("isRunningOnEmulator", easyConfigMod.isRunningOnEmulator());
        result.put("time", easyConfigMod.getTime());
        result.put("uptime", easyConfigMod.getUpTime());
        result.put("formattedTime", easyConfigMod.getFormattedTime());
        result.put("currentDate", easyConfigMod.getCurrentDate().getTime());
        result.put("formattedDate", easyConfigMod.getFormattedDate());
        result.put("hasSdCard", easyConfigMod.hasSdCard());

        @RingerMode
        int ringermode = easyConfigMod.getDeviceRingerMode();
        switch (ringermode) {
            case RingerMode.NORMAL:
                result.put("ringerMode", "Normal");
                break;
            case RingerMode.VIBRATE:
                result.put("ringerMode", "Vibrate");
                break;
            case RingerMode.SILENT:
                result.put("ringerMode", "Silent");
                break;
            default:
                result.put("ringerMode", "-");
                break;
        }

        return result;
    }

}
