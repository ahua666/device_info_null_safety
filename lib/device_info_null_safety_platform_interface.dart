import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'device_info_null_safety_method_channel.dart';
import 'memory_info_enum.dart';

abstract class DeviceInfoNullSafetyPlatform extends PlatformInterface {
  /// Constructs a DeviceInfoNullSafetyPlatform.
  DeviceInfoNullSafetyPlatform() : super(token: _token);

  static final Object _token = Object();

  static DeviceInfoNullSafetyPlatform _instance =
      MethodChannelDeviceInfoNullSafety();

  /// The default instance of [DeviceInfoNullSafetyPlatform] to use.
  ///
  /// Defaults to [MethodChannelDeviceInfoNullSafety].
  static DeviceInfoNullSafetyPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [DeviceInfoNullSafetyPlatform] when
  /// they register themselves.
  static set instance(DeviceInfoNullSafetyPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<Map<String, dynamic>> getBatteryInfo() {
    throw UnimplementedError('getBatteryInfo() has not been implemented.');
  }

  Future<Map<String, dynamic>> getAbiInfo() {
    throw UnimplementedError('getAbiInfo() has not been implemented.');
  }

  Future<List<Map<String, dynamic>>> getSensorInfo() {
    throw UnimplementedError('getSensorInfo() has not been implemented.');
  }

  Future<Map<String, dynamic>> getMemoryInfo(
      {required MemoryInfoUnit memoryInfoUnit}) {
    throw UnimplementedError(
        'getMemoryInfo({required MemoryInfoUnit memoryInfoUnit}) has not been implemented.');
  }

  Future<Map<String, dynamic>> getFingerprintInfo() {
    throw UnimplementedError('getFingerprintInfo() has not been implemented.');
  }

  Future<Map<String, dynamic>> getSystemInfo() {
    throw UnimplementedError('getSystemInfo() has not been implemented.');
  }

  Future<Map<String, dynamic>> getDisplayInfo() {
    throw UnimplementedError('getDisplayInfo() has not been implemented.');
  }

  Future<Map<String, dynamic>> getConfigInfo() {
    throw UnimplementedError('getConfigInfo() has not been implemented.');
  }

  Future<Map<String, dynamic>> getSimInfo() {
    throw UnimplementedError('getSimInfo() has not been implemented.');
  }

  Future<Map<String, dynamic>> getNfcInfo() {
    throw UnimplementedError('getNfcInfo() has not been implemented.');
  }

  Future<Map<String, dynamic>> getNetworkInfo() {
    throw UnimplementedError('getNetworkInfo() has not been implemented.');
  }

  Future<Map<String, dynamic>> getLocationInfo() {
    throw UnimplementedError('getLocationInfo() has not been implemented.');
  }
}
