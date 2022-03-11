package com.prongbang.device_detect

interface DetectUtility {
    fun isMi(): Boolean
    fun hasSystemProperty(propName: String): Boolean
    fun getSystemProperty(propName: String): String?
}