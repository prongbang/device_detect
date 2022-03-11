# device_detect

Detect android device info, MIUI version, etc.

## Getting Started

It is really easy to use!
You should ensure that you add the `device_detect` as a dependency in your flutter project, Supported Android only.

```yaml
dependencies:
  device_detect: "^1.0.0"
```

## Feature

- Detect MIUI

```dart
final result = await DeviceDetect.isMi;
```

- Detect by System Property

```dart
final result = await DeviceDetect.hasSystemProperty('ro.miui.ui.version.name');
```

## Usage

```dart
import 'package:device_detect/device_detect.dart';
import 'package:flutter/material.dart';

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
```