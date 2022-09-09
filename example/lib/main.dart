import 'package:device_info_null_safety/device_info_null_safety.dart';
import 'package:device_info_null_safety/memory_info_enum.dart';
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

  ListView getWidget(AsyncSnapshot<Map<String, dynamic>> snapshot) {
    return ListView(
      children: snapshot.data!.entries
          .map((val) => ListTile(
                title: Text(val.key.toString().toUpperCase()),
                subtitle: Text(val.value.toString().toUpperCase()),
              ))
          .toList(),
    );
  }

  Widget getBuilder(Future<Map<String, dynamic>> future) {
    return FutureBuilder(
      future: future,
      builder: (context, AsyncSnapshot<Map<String, dynamic>> snapshot) {
        if (snapshot.hasData) {
          return getWidget(snapshot);
        }
        return const Center(
          child: CircularProgressIndicator(),
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: DefaultTabController(
        length: 11,
        animationDuration: const Duration(milliseconds: 500),
        child: Scaffold(
          appBar: AppBar(
            title: const Text('Device Info Null Safety'),
            bottom: const TabBar(
              isScrollable: true,
              tabs: [
                Tab(child: Text('Battery Info')),
                Tab(child: Text('Abi Info')),
                Tab(child: Text('Sensor Info')),
                Tab(child: Text('Memory Info')),
                Tab(child: Text('Finger Print Info')),
                Tab(child: Text('System Info')),
                Tab(child: Text('Config Info')),
                Tab(child: Text('Display Info')),
                Tab(child: Text('Nfc Info')),
                Tab(child: Text('Network Info')),
                Tab(child: Text('Location Info')),
              ],
            ),
          ),
          body: TabBarView(
            children: [
              getBuilder(_deviceInfoNullSafety.batteryInfo),
              getBuilder(_deviceInfoNullSafety.abiInfo),
              FutureBuilder(
                future: _deviceInfoNullSafety.sensorInfo,
                builder: (context,
                    AsyncSnapshot<List<Map<String, dynamic>>> snapshot) {
                  if (snapshot.hasData) {
                    return ListView(
                      children: snapshot.data!
                          .map((val) => ExpansionTile(
                                initiallyExpanded: true,
                                title: Text(val['name']),
                                children: val.entries
                                    .map((e) => ListTile(
                                          leading: Text(e.key.toUpperCase()),
                                          trailing: Text(
                                              e.value.toString().toUpperCase()),
                                        ))
                                    .toList(),
                              ))
                          .toList(),
                    );
                  }
                  return const Center(
                    child: CircularProgressIndicator(),
                  );
                },
              ),
              getBuilder(_deviceInfoNullSafety.memoryInfo(
                  memoryInfoUnit: MemoryInfoUnit.gb)),
              getBuilder(_deviceInfoNullSafety.fingerPrintInfo),
              getBuilder(_deviceInfoNullSafety.systemInfo),
              getBuilder(_deviceInfoNullSafety.configInfo),
              getBuilder(_deviceInfoNullSafety.displayInfo),
              getBuilder(_deviceInfoNullSafety.nfcInfo),
              getBuilder(_deviceInfoNullSafety.networkInfo),
              getBuilder(_deviceInfoNullSafety.locationInfo),
            ],
          ),
        ),
      ),
    );
  }
}
