import 'package:device_info_null_safety/memory_info_enum.dart';

import 'device_info_null_safety_platform_interface.dart';

///main class exposed to user for different device information
class DeviceInfoNullSafety {
  final DeviceInfoNullSafetyPlatform _instance =
      DeviceInfoNullSafetyPlatform.instance;

  /// get Battery info with this getter
  Future<Map<String, dynamic>> get batteryInfo => _instance.getBatteryInfo();

  /// get ABi info with this getter
  Future<Map<String, dynamic>> get abiInfo => _instance.getAbiInfo();

  /// get Sensor info with this getter
  Future<List<Map<String, dynamic>>> get sensorInfo =>
      _instance.getSensorInfo();

  /// get Memory info with this getter
  Future<Map<String, dynamic>> memoryInfo(
          {required MemoryInfoUnit memoryInfoUnit}) =>
      _instance.getMemoryInfo(memoryInfoUnit: memoryInfoUnit);

  /// get Finger Print info with this getter
  Future<Map<String, dynamic>> get fingerPrintInfo =>
      _instance.getFingerprintInfo();

  /// get System info with this getter
  Future<Map<String, dynamic>> get systemInfo => _instance.getSystemInfo();

  /// get Display info with this getter
  Future<Map<String, dynamic>> get displayInfo => _instance.getDisplayInfo();

  /// get Config info with this getter
  Future<Map<String, dynamic>> get configInfo => _instance.getConfigInfo();

  ///As for Now Don't use SimInfo Getter
  // Future<Map<String, dynamic>> get simInfo => _instance.getSimInfo();
  /// get NFC info with this getter
  Future<Map<String, dynamic>> get nfcInfo => _instance.getNfcInfo();

  /// get Network info with this getter
  Future<Map<String, dynamic>> get networkInfo => _instance.getNetworkInfo();

  /// get Location info with this getter
  /// to use these getter you must use permission handler to get current location of user
  Future<Map<String, dynamic>> get locationInfo => _instance.getLocationInfo();
}
