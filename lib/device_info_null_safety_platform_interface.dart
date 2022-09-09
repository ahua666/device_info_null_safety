import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'device_info_null_safety_method_channel.dart';

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
}
