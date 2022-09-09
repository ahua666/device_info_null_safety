package com.divit.device_info_null_safety;

import android.content.Context;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.EasyMemoryMod;

public class DeviceMemoryInfo {

    private final Context context;

    public DeviceMemoryInfo(Context context) {
        this.context = context;
    }

    public HashMap<String, Object> getMemoryInfo(String unit) {

        EasyMemoryMod easyMemoryMod = new EasyMemoryMod(this.context);

        float totalRAM;
        float availableInternalMemorySize;
        float availableExternalMemorySize;
        float totalInternalMemorySize;
        float totalExternalMemorySize;

        switch (unit.toLowerCase()) {

            case "kb":
                totalRAM = easyMemoryMod.convertToKb(easyMemoryMod.getTotalRAM());
                availableInternalMemorySize = easyMemoryMod.convertToKb(easyMemoryMod.getAvailableInternalMemorySize());
                availableExternalMemorySize = easyMemoryMod.convertToKb(easyMemoryMod.getAvailableExternalMemorySize());
                totalInternalMemorySize = easyMemoryMod.convertToKb(easyMemoryMod.getTotalInternalMemorySize());
                totalExternalMemorySize = easyMemoryMod.convertToKb(easyMemoryMod.getTotalExternalMemorySize());
                break;

            case "mb":
                totalRAM = easyMemoryMod.convertToMb(easyMemoryMod.getTotalRAM());
                availableInternalMemorySize = easyMemoryMod.convertToMb(easyMemoryMod.getAvailableInternalMemorySize());
                availableExternalMemorySize = easyMemoryMod.convertToMb(easyMemoryMod.getAvailableExternalMemorySize());
                totalInternalMemorySize = easyMemoryMod.convertToMb(easyMemoryMod.getTotalInternalMemorySize());
                totalExternalMemorySize = easyMemoryMod.convertToMb(easyMemoryMod.getTotalExternalMemorySize());
                break;

            case "gb":
                totalRAM = easyMemoryMod.convertToGb(easyMemoryMod.getTotalRAM());
                availableInternalMemorySize = easyMemoryMod.convertToGb(easyMemoryMod.getAvailableInternalMemorySize());
                availableExternalMemorySize = easyMemoryMod.convertToGb(easyMemoryMod.getAvailableExternalMemorySize());
                totalInternalMemorySize = easyMemoryMod.convertToGb(easyMemoryMod.getTotalInternalMemorySize());
                totalExternalMemorySize = easyMemoryMod.convertToGb(easyMemoryMod.getTotalExternalMemorySize());
                break;

            default: // bytes
                totalRAM = easyMemoryMod.getTotalRAM();
                availableInternalMemorySize = easyMemoryMod.getAvailableInternalMemorySize();
                availableExternalMemorySize = easyMemoryMod.getAvailableExternalMemorySize();
                totalInternalMemorySize = easyMemoryMod.getTotalInternalMemorySize();
                totalExternalMemorySize = easyMemoryMod.getTotalExternalMemorySize();
                break;
        }

        HashMap<String, Object> result = new HashMap<>();

        result.put("totalRAM", totalRAM);
        result.put("availableInternalMemorySize", availableInternalMemorySize);
        result.put("availableExternalMemorySize", availableExternalMemorySize);
        result.put("totalInternalMemorySize", totalInternalMemorySize);
        result.put("totalExternalMemorySize", totalExternalMemorySize);

        return result;
    }

}
