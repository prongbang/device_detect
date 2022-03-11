import 'dart:async';

import 'package:flutter/services.dart';

class DeviceDetect {
  static const MethodChannel _channel = MethodChannel('device_detect');

  static Future<bool> get isMi async => await _channel.invokeMethod('isMi');

  static Future<bool> hasSystemProperty(String propertyName) async =>
      await _channel.invokeMethod('hasSystemProperty', <String, String>{
        'systemProperty': propertyName,
      });
}
