package com.prongbang.device_detect

import android.text.TextUtils
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * Thank you: Muyangmin - https://gist.github.com/Muyangmin/e8ec1002c930d8df3df46b306d03315d
 */
class DeviceDetectUtility : DetectUtility {

    override fun isMi(): Boolean = checkSystemProperty("ro.miui.ui.version.name")

    override fun hasSystemProperty(propName: String): Boolean = checkSystemProperty(propName)

    override fun getSystemProperty(propName: String): String? {
        val line: String
        var input: BufferedReader? = null
        try {
            val p = Runtime.getRuntime().exec("getprop $propName")
            input = BufferedReader(InputStreamReader(p.inputStream), 1024)
            line = input.readLine()
            input.close()
        } catch (ex: IOException) {
            return null
        } finally {
            if (input != null) {
                try {
                    input.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return line
    }

    private fun checkSystemProperty(propName: String): Boolean =
        !TextUtils.isEmpty(getSystemProperty(propName))
}