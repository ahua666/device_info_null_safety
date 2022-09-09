import 'dart:convert';

import 'package:device_info_null_safety/memory_info_enum.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'device_info_null_safety_platform_interface.dart';

/// An implementation of [DeviceInfoNullSafetyPlatform] that uses method channels.
class MethodChannelDeviceInfoNullSafety extends DeviceInfoNullSafetyPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('device_info_null_safety');

  final JsonEncoder _jsonEncoder = const JsonEncoder();

  @override
  Future<Map<String, dynamic>> getBatteryInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final batteryInfo = await methodChannel
          .invokeMethod<Map<dynamic, dynamic>>('getBatteryInfo');
      return jsonDecode(_jsonEncoder.convert(batteryInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }

  @override
  Future<Map<String, dynamic>> getAbiInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final abiInfo =
          await methodChannel.invokeMethod<Map<dynamic, dynamic>>('getAbiInfo');

      return jsonDecode(_jsonEncoder.convert(abiInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }

  @override
  Future<List<Map<String, dynamic>>> getSensorInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final sensorInfo =
          await methodChannel.invokeMethod<List<Object?>>('getSensorInfo');
      List<Map<String, dynamic>> finalResult = <Map<String, dynamic>>[];
      for (Map<String, dynamic> single
          in jsonDecode(_jsonEncoder.convert(sensorInfo))) {
        finalResult.add(single);
      }

      return finalResult;
    } on PlatformException catch (error) {
      return [
        result
          ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)],
          ),
      ];
    }
  }

  @override
  Future<Map<String, dynamic>> getMemoryInfo(
      {required MemoryInfoUnit memoryInfoUnit}) async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final memoryInfo =
          await methodChannel.invokeMethod<Map<dynamic, dynamic>>(
              'getMemoryInfo', memoryInfoUnit.name);

      return jsonDecode(_jsonEncoder.convert(memoryInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }

  @override
  Future<Map<String, dynamic>> getFingerprintInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final fingerPrintInfo = await methodChannel
          .invokeMethod<Map<dynamic, dynamic>>('getFingerPrintInfo');

      return jsonDecode(_jsonEncoder.convert(fingerPrintInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }

  @override
  Future<Map<String, dynamic>> getDisplayInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final displayInfo = await methodChannel
          .invokeMethod<Map<dynamic, dynamic>>('getDisplayInfo');

      return jsonDecode(_jsonEncoder.convert(displayInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }

  @override
  Future<Map<String, dynamic>> getNfcInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final nfcInfo =
          await methodChannel.invokeMethod<Map<dynamic, dynamic>>('getNfcInfo');

      return jsonDecode(_jsonEncoder.convert(nfcInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }

  @override
  Future<Map<String, dynamic>> getLocationInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final locationInfo = await methodChannel
          .invokeMethod<Map<dynamic, dynamic>>('getLocationInfo');

      return jsonDecode(_jsonEncoder.convert(locationInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }

  @override
  Future<Map<String, dynamic>> getNetworkInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final networkInfo = await methodChannel
          .invokeMethod<Map<dynamic, dynamic>>('getNetworkInfo');

      return jsonDecode(_jsonEncoder.convert(networkInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }

  @override
  Future<Map<String, dynamic>> getSimInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final simInfo =
          await methodChannel.invokeMethod<Map<dynamic, dynamic>>('getSimInfo');

      return jsonDecode(_jsonEncoder.convert(simInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }

  @override
  Future<Map<String, dynamic>> getConfigInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final configInfo = await methodChannel
          .invokeMethod<Map<dynamic, dynamic>>('getConfigInfo');

      return jsonDecode(_jsonEncoder.convert(configInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }

  @override
  Future<Map<String, dynamic>> getSystemInfo() async {
    Map<String, dynamic> result = <String, dynamic>{};

    try {
      final systemInfo = await methodChannel
          .invokeMethod<Map<dynamic, dynamic>>('getSystemInfo');

      return jsonDecode(_jsonEncoder.convert(systemInfo));
    } on PlatformException catch (error) {
      return result
        ..addEntries(
            [MapEntry("code", error.code), MapEntry("message", error.message)]);
    }
  }
}
