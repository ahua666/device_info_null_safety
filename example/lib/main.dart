import 'package:device_info_null_safety/device_info_null_safety.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final DeviceInfoNullSafety _deviceInfoNullSafety = DeviceInfoNullSafety();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: TextButton(
            onPressed: () async {
              Map<String, dynamic> data =
                  await _deviceInfoNullSafety.fingerPrintInfo;

              print(data);
            },
            child: const Text('Call Button'),
          ),
        ),
      ),
    );
  }
}
