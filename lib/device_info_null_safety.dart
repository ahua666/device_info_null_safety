import 'device_info_null_safety_platform_interface.dart';

class DeviceInfoNullSafety {
  Future<Map<String, dynamic>> get batteryInfo =>
      DeviceInfoNullSafetyPlatform.instance.getBatteryInfo();

  Future<Map<String, dynamic>> get abiInfo =>
      DeviceInfoNullSafetyPlatform.instance.getAbiInfo();

  Future<List<Map<String, dynamic>>> get sensorInfo =>
      DeviceInfoNullSafetyPlatform.instance.getSensorInfo();
}
