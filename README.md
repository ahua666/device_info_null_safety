# device_info_null_safety

A Flutter plugin for getting device information on Android devices.

This package is a binding for [EasyDeviceInfo](https://github.com/nisrulz/easydeviceinfo).

Permissions are not handled by the library, please use [permission_handler](https://pub.dartlang.org/packages/permission_handler) to handle permissions.
```
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.READ_SMS" />
    <uses-permission android:name="android.permission.READ_PHONE_NUMBERS" />
    <uses-permission android:name="android.permission.USE_FINGERPRINT" />
    <uses-feature android:name="android.hardware.fingerprint" android:required="true" />
```

## import

```dart
import 'package:device_info_null_safety/device_info_null_safety.dart';
```

## Battery Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
Map<String,dynamic> batteryInfo = await _deviceInfoNullSafety.batteryInfo;
print(batteryInfo);
```

## Abi Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
Map<String,dynamic> abiInfo = await _deviceInfoNullSafety.abiInfo;
print(abiInfo);
```

## Sensor Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
List<Map<String, dynamic>> sensorInfo = await _deviceInfoNullSafety.sensorInfo;
print(sensorInfo);
```

## Memory Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
Map<String,dynamic> memoryInfo = await _deviceInfoNullSafety.memoryInfo(memoryInfoUnit: MemoryInfoUnit.gb);
print(memoryInfo);
```

## Finger Print Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
Map<String,dynamic> fingerPrintInfo = await _deviceInfoNullSafety.fingerPrintInfo;
print(fingerPrintInfo);
```

## System Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
Map<String,dynamic> systemInfo = await _deviceInfoNullSafety.systemInfo;
print(systemInfo);
```

## Display Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
Map<String,dynamic> displayInfo = await _deviceInfoNullSafety.displayInfo;
print(displayInfo);
```

## Config Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
Map<String,dynamic> configInfo = await _deviceInfoNullSafety.configInfo;
print(configInfo);
```

## NFC Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
Map<String,dynamic> nfcInfo = await _deviceInfoNullSafety.nfcInfo;
print(nfcInfo);
```

## Network Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
Map<String,dynamic> networkInfo = await _deviceInfoNullSafety.networkInfo;
print(networkInfo);
```

## Location Info
```
final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();
Map<String,dynamic> locationInfo = await _deviceInfoNullSafety.locationInfo;
print(locationInfo);
```
