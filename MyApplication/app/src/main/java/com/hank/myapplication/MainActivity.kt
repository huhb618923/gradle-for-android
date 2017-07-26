package com.hank.myapplication

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mVersionName: String? = null
    private var mVersionCode: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val packageInfo = packageManager.getPackageInfo(packageName, 0)
            mVersionName = packageInfo.versionName
            mVersionCode = packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        text_view.setText("PackageName:"+ packageName + "\nVersionCode:" + mVersionCode + "\nVersionName:" + mVersionName);
        Log.e("MainActivity", this.getString(R.string.AppName))
    }
}
