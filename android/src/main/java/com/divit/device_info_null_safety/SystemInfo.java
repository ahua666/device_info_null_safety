package com.divit.device_info_null_safety;

import android.app.Activity;
import android.content.Context;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.DeviceType;
import github.nisrulz.easydeviceinfo.base.EasyDeviceMod;
import github.nisrulz.easydeviceinfo.base.OrientationType;
import github.nisrulz.easydeviceinfo.base.PhoneType;

public class SystemInfo {
    private final Context context;
    private final Activity activity;


    public SystemInfo(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }


    public HashMap<String, Object> getSystemInfo() {

        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.context);

        HashMap<String, Object> result = new HashMap<>();

        result.put("screenDisplayID", easyDeviceMod.getScreenDisplayID());
        result.put("buildVersionCodename", easyDeviceMod.getBuildVersionCodename());
        result.put("buildVersionIncremental", easyDeviceMod.getBuildVersionIncremental());
        result.put("buildVersionSDK", easyDeviceMod.getBuildVersionSDK());
        result.put("buildID", easyDeviceMod.getBuildID());
        result.put("manufacturer", easyDeviceMod.getManufacturer());
        result.put("model", easyDeviceMod.getModel());
        result.put("osCodename", easyDeviceMod.getOSCodename());
        result.put("osVersion", easyDeviceMod.getOSVersion());
        result.put("phoneNo", easyDeviceMod.getPhoneNo()); // READ_PHONE_STATE
        result.put("radioVer", easyDeviceMod.getRadioVer());
        result.put("product", easyDeviceMod.getProduct());
        result.put("device", easyDeviceMod.getDevice());
        result.put("board", easyDeviceMod.getBoard());
        result.put("hardware", easyDeviceMod.getHardware());
        result.put("bootloader", easyDeviceMod.getBootloader());
        result.put("fingerprint", easyDeviceMod.getFingerprint());
        result.put("isDeviceRooted", easyDeviceMod.isDeviceRooted());
        result.put("buildBrand", easyDeviceMod.getBuildBrand());
        result.put("buildHost", easyDeviceMod.getBuildHost());
        result.put("buildTags", easyDeviceMod.getBuildTags());
        result.put("buildTime", easyDeviceMod.getBuildTime());
        result.put("buildUser", easyDeviceMod.getBuildUser());
        result.put("buildVersionRelease", easyDeviceMod.getBuildVersionRelease());

        @DeviceType
        int deviceType = easyDeviceMod.getDeviceType(this.activity);
        switch (deviceType) {
            case DeviceType.WATCH:
                result.put("deviceType", "watch");
                break;
            case DeviceType.PHONE:
                result.put("deviceType", "phone");
                break;
            case DeviceType.PHABLET:
                result.put("deviceType", "phablet");
                break;
            case DeviceType.TABLET:
                result.put("deviceType", "tablet");
                break;
            case DeviceType.TV:
                result.put("deviceType", "tv");
                break;
        }

        @PhoneType
        int phoneType = easyDeviceMod.getPhoneType();
        switch (phoneType) {
            case PhoneType.CDMA:
                result.put("phoneType", "CDMA");
                break;
            case PhoneType.GSM:
                result.put("phoneType", "GSM");
                break;
            case PhoneType.NONE:
                result.put("phoneType", "NONE");
                break;
            default:
                result.put("phoneType", "Unknown");
                break;
        }

        @OrientationType
        int orientationType = easyDeviceMod.getOrientation(this.activity);
        switch (orientationType) {
            case OrientationType.LANDSCAPE:
                result.put("orientation", "landscape");
                break;
            case OrientationType.PORTRAIT:
                result.put("orientation", "portrait");
                break;
            case OrientationType.UNKNOWN:
            default:
                result.put("orientation", "Unknown");
                break;
        }

        return result;
    }
}
