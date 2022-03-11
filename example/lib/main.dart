import 'package:device_detect/device_detect.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: const Text('Plugin example app')),
        body: Center(
          child: Column(
            children: [
              FutureBuilder(
                future: DeviceDetect.isMi,
                builder: (_, snapshot) => Text('MIUI: ${snapshot.data}'),
              ),
              FutureBuilder(
                future: DeviceDetect.hasSystemProperty(
                  'ro.miui.ui.version.name',
                ),
                builder: (_, snapshot) => Text('MIUI: ${snapshot.data}'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
