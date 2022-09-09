package com.divit.device_info_null_safety;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;


public class DeviceInfoNullSafetyPlugin implements FlutterPlugin, MethodCallHandler {

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
            ;
        } else {
            result.notImplemented();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }


}
