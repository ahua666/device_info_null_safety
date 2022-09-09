import 'package:device_info_null_safety/memory_info_enum.dart';

import 'device_info_null_safety_platform_interface.dart';

class DeviceInfoNullSafety {
  final DeviceInfoNullSafetyPlatform _instance =
      DeviceInfoNullSafetyPlatform.instance;

  Future<Map<String, dynamic>> get batteryInfo => _instance.getBatteryInfo();

  Future<Map<String, dynamic>> get abiInfo => _instance.getAbiInfo();

  Future<List<Map<String, dynamic>>> get sensorInfo =>
      _instance.getSensorInfo();

  Future<Map<String, dynamic>> memoryInfo(
          {required MemoryInfoUnit memoryInfoUnit}) =>
      _instance.getMemoryInfo(memoryInfoUnit: memoryInfoUnit);

  Future<Map<String, dynamic>> get fingerPrintInfo =>
      _instance.getFingerprintInfo();

  Future<Map<String, dynamic>> get systemInfo => _instance.getSystemInfo();

  Future<Map<String, dynamic>> get displayInfo => _instance.getDisplayInfo();

  Future<Map<String, dynamic>> get configInfo => _instance.getConfigInfo();

  ///As of Now Don't use SimInfo Getter
  // Future<Map<String, dynamic>> get simInfo => _instance.getSimInfo();

  Future<Map<String, dynamic>> get nfcInfo => _instance.getNfcInfo();

  Future<Map<String, dynamic>> get networkInfo => _instance.getNetworkInfo();

  Future<Map<String, dynamic>> get locationInfo => _instance.getLocationInfo();
}
