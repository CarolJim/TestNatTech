package com.example.testnat.ui.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.testnat.R
import com.example.testnat.util.Util
import com.example.testnat.util.Util.Companion.MY_PERMISSIONS_STORAGE
import com.example.testnat.util.Util.Companion.REQUEST_EXTERNAL_STORAGE

class SplashActivity : AppCompatActivity() {

    // Duración en milisegundos que se mostrará el splash
    private val DURACION_SPLASH = 5000 // 3 segundos


    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        hideSystemUIAndNavigation(this)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            requestPermission()
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun hideSystemUIAndNavigation(activity: Activity) {
        val decorView: View = activity.window.decorView
        decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_IMMERSIVE
                    // Set the content to appear under the system bars so that the
                    // content doesn't resize when the system bars hide and show.
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN // Hide the nav bar and status bar
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun requestPermission() {
        val checkCallPhonePermission: Int = ContextCompat.checkSelfPermission(
            this@SplashActivity,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
            Util.printLog("No tiene chance")
            ActivityCompat.requestPermissions(
                this@SplashActivity,
                MY_PERMISSIONS_STORAGE,
                REQUEST_EXTERNAL_STORAGE
            )
        } else {
            Util.printLog("Si tiene chance")
            initialization()
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun initialization() {
        Handler().postDelayed({
                // Cuando pasen los 5 segundos, pasamos a la actividad principal de la aplicación
                val intent =  Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
        }, DURACION_SPLASH.toLong())
    }


    @RequiresApi(Build.VERSION_CODES.P)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_EXTERNAL_STORAGE)
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Util.printLog("Ya tiene chance")
                initialization()
            } else {
                Util.printLog("No le dio chance")
                Util.toastMake(getString(R.string.label_need_permission))

                ActivityCompat.requestPermissions(
                    this@SplashActivity,
                    MY_PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
                )
            }
    }


}