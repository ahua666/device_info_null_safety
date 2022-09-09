package com.divit.device_info_null_safety;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;


public class DeviceInfoNullSafetyPlugin implements FlutterPlugin, MethodCallHandler, ActivityAware {

    private MethodChannel channel;
    private Context context;
    private Activity activity;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
        channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "device_info_null_safety");
        channel.setMethodCallHandler(this);
        context = flutterPluginBinding.getApplicationContext();
    }

    @Override
    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        activity = binding.getActivity();

    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        if ("getAbiInfo".equals(call.method)) {
            ABIInfo ABIInfo = new ABIInfo();
            result.success(ABIInfo.getAbiInfo());
        } else if ("getBatteryInfo".equals(call.method)) {
            BatteryInfo batteryInfo = new BatteryInfo(this.context);
            result.success(batteryInfo.getBatteryInfo());
        } else if ("getSensorInfo".equals(call.method)) {
            SensorInfo sensorInfo = new SensorInfo(this.context);
            result.success(sensorInfo.getSensorInfo());
        } else if ("getMemoryInfo".equals(call.method)) {
            DeviceMemoryInfo deviceMemoryInfo = new DeviceMemoryInfo(this.context);
            result.success(deviceMemoryInfo.getMemoryInfo(call.arguments.toString()));
        } else if ("getFingerPrintInfo".equals(call.method)) {
            FingerPrintInfo fingerPrintInfo = new FingerPrintInfo(this.context);
            result.success(fingerPrintInfo.getFingerprintInfo());
        } else if ("getNfcInfo".equals(call.method)) {
            NFCInfo nfcInfo = new NFCInfo(this.context);
            result.success(nfcInfo.getNfcInfo());
        } else if ("getDisplayInfo".equals(call.method)) {
            DisplayInfo displayInfo = new DisplayInfo(this.context);
            result.success(displayInfo.getDisplayInfo());
        } else if ("getLocationInfo".equals(call.method)) {
            LocationInfo locationInfo = new LocationInfo(this.context);
            result.success(locationInfo.getLocationInfo());
        } else if ("getNetworkInfo".equals(call.method)) {
            NetworkInfo networkInfo = new NetworkInfo(this.context);
            result.success(networkInfo.getNetworkInfo());
        } else if ("getConfigInfo".equals(call.method)) {
            ConfigInfo configInfo = new ConfigInfo(this.context);
            result.success(configInfo.getConfigInfo());
        } else if ("getSimInfo".equals(call.method)) {
            SimInfo simInfo = new SimInfo(this.context);
            result.success(simInfo.getSimInfo());
        } else if ("getSystemInfo".equals(call.method)) {
            SystemInfo systemInfo = new SystemInfo(this.context, this.activity);
            result.success(systemInfo.getSystemInfo());
        } else {
            result.notImplemented();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }


    @Override
    public void onDetachedFromActivityForConfigChanges() {

    }

    @Override
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {

    }

    @Override
    public void onDetachedFromActivity() {

    }
}
