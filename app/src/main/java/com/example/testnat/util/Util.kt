package com.example.testnat.util

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.testnat.common.MyApp

class Util {

    companion object {
        fun printLog(log: String) {
            Log.i("Error:", log)
        }

        fun printLogError(log: String) {
            Log.e("Error:", log)
        }

        /** Permission */
        val REQUEST_EXTERNAL_STORAGE = 1

        var MY_PERMISSIONS_STORAGE: Array<String> = arrayOf(
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.MOUNT_UNMOUNT_FILESYSTEMS"
        )

        fun toastMake(message: String){
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(MyApp.instance, message, Toast.LENGTH_LONG).show()
            }
        }

    }



}